package com.example.models.dto.viewModels.user;

import com.example.models.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserToken {

        private String id;
        private String username;
        private String email;
        private String phone;
        private String birthday;
        private String address;
        private String city;
        private Set<UserRole> role;
        private String token;

    public UserToken(String id, String username, String email, String phone, String birthday, String address, String city, Set<UserRole> role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.city = city;
        this.role = role;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", role='" + role + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
