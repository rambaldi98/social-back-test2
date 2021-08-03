package com.example.back.valid.annotations;

import com.example.back.domain.entities.User;
import com.example.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    private UserService userService;

    @Autowired
    public UniqueUsernameValidator(UserService userService){
        this.userService = userService;
    }
    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User user = this.userService.getByUsernameValidation(value);
        return user == null;
    }
}
