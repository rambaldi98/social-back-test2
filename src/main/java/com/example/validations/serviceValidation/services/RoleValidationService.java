package com.example.validations.serviceValidation.services;

import com.example.models.entities.UserRole;

public interface RoleValidationService {
    boolean isValid(UserRole role);
}
