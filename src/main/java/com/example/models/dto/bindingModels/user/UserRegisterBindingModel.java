package com.example.models.dto.bindingModels.user;

import com.example.utils.constants.ValidationMessageConstants;
import com.example.validations.annotations.Password;
import com.example.validations.annotations.PasswordMatching;
import com.example.validations.annotations.UniqueEmail;
import com.example.validations.annotations.UniqueUsername;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@PasswordMatching
public class UserRegisterBindingModel implements Serializable {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    @NotBlank
    @Size(min = 10, max = 12)
    private String phone;
    private String birthday;
    private String address;
    private String city;
    private String profilePicUrl;
    private String backgroundImageUrl;

    public UserRegisterBindingModel() {
    }

    @Pattern(regexp = "^([a-zA-Z0-9]+)$")
    @Size(min = 4, max = 16, message = ValidationMessageConstants.USER_INVALID_USERNAME_MESSAGE)
    @UniqueUsername
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$",message = ValidationMessageConstants.USER_INVALID_EMAIL_MESSAGE)
    @UniqueEmail
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Password(minLength = 4, maxLength = 16, containsOnlyLettersAndDigits = true, message = ValidationMessageConstants.USER_INVALID_PASSWORD_MESSAGE)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @NotNull(message = ValidationMessageConstants.USER_ADDRESS_REQUIRED_MESSAGE)
    @Length(min = 1, message = ValidationMessageConstants.USER_ADDRESS_REQUIRED_MESSAGE)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotNull(message = ValidationMessageConstants.USER_CITY_REQUIRED_MESSAGE)
    @Length(min = 1, message = ValidationMessageConstants.USER_CITY_REQUIRED_MESSAGE)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfilePicUrl() {
        return this.profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getBackgroundImageUrl() {
        return this.backgroundImageUrl;
    }

    public void setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
    }
}
