package com.example.back.domain.entities;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;

public class User extends BaseEntity implements UserDetails {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    // set trang thai
    private boolean isDeleted;

    private Set<UserRole> authorities;

    private String profilepicUrl;
    private String backgroundImgeUrl;

    private boolean isOnline;

    public User (){
        this.authorities = new HashSet<>();
    }

    @Override
    @Column(nullable = false,name = "username",unique = true,columnDefinition = "VARCHAR(50) BINARY")
    public
}
