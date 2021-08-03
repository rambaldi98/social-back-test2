package com.example.back.valid.annotations;

import com.example.back.domain.models.bindingmodel.user.UserRegisterUserBindingModel;
import org.hibernate.mapping.Constraint;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching,Object> {

    @Override
    public void initialize(PasswordMatching constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value instanceof UserRegisterUserBindingModel){
            UserRegisterUserBindingModel user = (UserRegisterUserBindingModel) value;
            return user.getPassword().equals(user.getConfirmPassword());
        }
        return false;
    }
}
