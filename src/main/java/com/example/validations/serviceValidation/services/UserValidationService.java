package com.example.validations.serviceValidation.services;
import com.example.models.entities.User;
import com.example.models.dto.bindingModels.user.UserRegisterBindingModel;
import com.example.models.dto.bindingModels.user.UserUpdateBindingModel;
import com.example.models.dto.serviceModels.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserValidationService {
    boolean isValid(User user);

    boolean isValid(UserServiceModel userServiceModel);

    boolean isValid(UserRegisterBindingModel userRegisterBindingModel);

    boolean isValid(String firstParam, String secondParam);

    boolean isValid(UserUpdateBindingModel userUpdateBindingModel);

    boolean isValid(UserDetails userData);
}
