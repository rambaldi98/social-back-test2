package com.example.back.domain.entities;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
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


    // cau hinh truong user detail
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;


    public User (){
        this.authorities = new HashSet<>();
    }

    @Override
    @Column(nullable = false,name = "username",unique = true,columnDefinition = "VARCHAR(50) BINARY")
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    @Column(nullable = false,name = "email", unique = true, columnDefinition = "VARCHAR(50) BINARY")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @Column(nullable = false,name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "first_name",nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column(name = "is_deleted", nullable = false , columnDefinition = "BOOLEAN DEFAULT FALSE")
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name ="users_roles",
            joinColumns =@JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    public Set<UserRole> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<UserRole> authorities) {
        this.authorities = authorities;
    }
    @Column(name="profile_pic_url", columnDefinition = "TEXT")
    public String getProfilepicUrl() {
        return profilepicUrl;
    }

    public void setProfilepicUrl(String profilepicUrl) {
        this.profilepicUrl = profilepicUrl;
    }
    @Column(name="background_image_url", columnDefinition = "TEXT")
    public String getBackgroundImgeUrl() {
        return backgroundImgeUrl;
    }

    public void setBackgroundImgeUrl(String backgroundImgeUrl) {
        this.backgroundImgeUrl = backgroundImgeUrl;
    }
    @Column(name = "is_online", nullable = false , columnDefinition = "BOOLEAN DEFAULT FALSE")
    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    // userdetail

    // cau hinh userdetail

    @Override
    @Column(name = "isAccountNonExpired", nullable = false,columnDefinition = "BOOLEAN DEFAULT TRUE" )
    public boolean isAccountNonExpired() {
        return true;
    }
    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    @Column(name = "is_account_non_locked", nullable = false , columnDefinition = "BOOLEAN DEFAULT TRUE")
    public boolean isAccountNonLocked() {
        return true;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    @Column(name = "is_credentials_non_expired", nullable = false , columnDefinition = "BOOLEAN DEFAULT TRUE")
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    @Override
    @Column(name = "is_enabled", nullable = false , columnDefinition = "BOOLEAN DEFAULT TRUE")
    public boolean isEnabled() {
        return false;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
