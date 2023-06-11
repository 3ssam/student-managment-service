package com.essam.student.management.services;

import com.essam.student.management.models.Authority;
import com.essam.student.management.projection.AuthorityProjection;
import com.essam.student.management.repositories.AuthorityRepository;
import com.essam.student.management.requests.AuthorityRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Transactional
    public AuthorityProjection createAuthority(AuthorityRequest request) {
        Authority authority = new Authority();
        authority.setName(request.getName());
        authority.setStatus(request.getStatus());
        authority = authorityRepository.save(authority);
        return authorityRepository.getAuthorityById(authority.getId());
    }

    @Transactional
    public AuthorityProjection updateAuthority(AuthorityRequest request, Long id) throws Exception {
        Authority authority = authorityRepository.findById(id).get();
        if (authority == null) {
            throw new Exception("Authority not found");
        }
        authority.setStatus(request.getStatus());
        authority = authorityRepository.save(authority);
        return authorityRepository.getAuthorityById(authority.getId());
    }


    public List<AuthorityProjection> getAllAuthorities() {
        return authorityRepository.findAllBy();
    }

    public AuthorityProjection getAuthority(Long id) throws Exception {
        AuthorityProjection authorityProjection = authorityRepository.getAuthorityById(id);
        if (authorityProjection == null) {
            throw new Exception("Authority not found");
        }
        return authorityProjection;
    }

    public Authority getAuthorityById(Long id) throws Exception {
        Authority authority = authorityRepository.findAuthorityById(id);
        if (authority == null) {
            throw new Exception("Authority not found");
        }
        return authority;
    }

    public Authority getAuthorityByName(String name) throws Exception {
        Authority authority = authorityRepository.getAuthorityByName(name);
        if (authority == null) {
            throw new Exception("Authority not found");
        }
        return authority;
    }

    @Transactional
    public void deleteAuthority(Long id) {
        authorityRepository.deleteById(id);
    }

}
