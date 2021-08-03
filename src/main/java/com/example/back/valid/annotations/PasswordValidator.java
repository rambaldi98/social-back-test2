package com.example.back.valid.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password,String>{

    private int minLength;
    private int maxLength;

    private boolean containsOnlyLettersAndDigits;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String regex ="^[a-zA-Z0-9]+$";
        if(value.length() < this.minLength || value.length() > this.maxLength){
            return false;
        }
        if(!Pattern.matches(regex,value) &&this.containsOnlyLettersAndDigits)
        return false;

        return true;
    }

    @Override
    public void initialize(Password constraintAnnotation) {
        this.minLength = constraintAnnotation.minLength();
        this.maxLength = constraintAnnotation.maxLength();
        this.containsOnlyLettersAndDigits = constraintAnnotation.containsOnlyLettersAndDigits();
    }
}
