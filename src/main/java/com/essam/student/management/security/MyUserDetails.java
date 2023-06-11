package com.essam.student.management.security;

import com.essam.student.management.models.Authority;
import com.essam.student.management.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
public class MyUserDetails implements UserDetails {


    private long id;
    private String email;
    private String username;
    private String password;
    private Date expirationPasswordDate;
    private String passwordHistory;
    private String name;
    private Boolean activated;
    private Boolean firstPassword;
    private Boolean suspended;
    private Integer loginTrial;
    private Set<GrantedAuthority> authorities;


    public MyUserDetails(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.suspended = user.getSuspended();
        this.activated = user.getActivated();
        this.authorities = collectAuthorities(user);
    }

    public MyUserDetails() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !suspended;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activated;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActivated() {
        return activated;
    }

    public Boolean getSuspended() {
        return suspended;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    private Set<GrantedAuthority> collectAuthorities(User user) {
        if (user.getRole() == null)
            return Collections.singleton(new SimpleGrantedAuthority("NO_AUTHORITIES"));
        return user.getRole().getAuthorities().stream().map(Authority::getName)
                .map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }

}
