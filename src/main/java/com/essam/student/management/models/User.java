package com.essam.student.management.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User extends BaseEntity {

    private static final long serialVersionUID = 4258129832216468499L;
    @Column(nullable = false)
    protected String name;
    private String email;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(name = "password_hash", nullable = false)
    private String password;
    private Boolean activated;
    private Boolean suspended;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
}
