package com.essam.student.management.repositories;

import com.essam.student.management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<User, Long> {
}
