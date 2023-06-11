package com.essam.student.management.repositories;

import com.essam.student.management.models.Authority;
import com.essam.student.management.projection.AuthorityProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    AuthorityProjection getAuthorityById(Long id);

    Authority getAuthorityByName(String name);

    Authority findAuthorityById(Long id);

    List<AuthorityProjection> findAllBy();
}
