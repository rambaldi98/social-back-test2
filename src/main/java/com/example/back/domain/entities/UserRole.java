package com.example.back.domain.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity implements GrantedAuthority {
    private String authority;

    public UserRole() {
    }

   @Column(name = "authority", nullable = false)

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
