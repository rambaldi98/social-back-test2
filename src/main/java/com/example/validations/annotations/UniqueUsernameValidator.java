package com.example.validations.annotations;
import com.example.models.entities.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    private UserService userService;

    @Autowired
    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UniqueUsername username) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        User user = this.userService.getByUsernameValidation(username);
        return user == null;
    }
}
