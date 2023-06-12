package com.essam.student.management.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    private static Logger logger = LogManager.getLogger(JwtTokenProvider.class);

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        MyUserDetails principal = (MyUserDetails) authentication.getPrincipal();
        Object userScope = principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        return Jwts.builder()
                .setHeaderParam("typ", "Bearer")
                .setSubject(String.valueOf(principal.getId()))
                .claim("usr", principal.getName())
                .claim("lgn", principal.getUsername())
                .claim("scp", userScope)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public MyUserDetails getPrinciple(String token) {
        Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        MyUserDetails.MyUserDetailsBuilder builder = MyUserDetails.builder();
        builder.id(Long.valueOf(body.getSubject()));
        builder.email(body.get("lgn").toString());
        builder.name(body.get("usr").toString());
        builder.authorities(getAuthorities(body.get("scp").toString()));
        return builder.build();
    }

    private Set<GrantedAuthority> getAuthorities(String scp) {
        return Arrays.stream(scp.split(",")).map(n -> {
            return n.replace(" ", "").replace("[", "").replace("]", "");
        }).map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
