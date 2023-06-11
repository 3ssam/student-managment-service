package com.essam.student.management.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4258129832216468499L;
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
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
