package com.example.validations.serviceValidation.servicesImpl;

import com.example.models.entities.UserRole;
import com.example.validations.serviceValidation.services.RoleValidationService;
import org.springframework.stereotype.Component;

@Component
public class RoleValidationServiceImpl implements RoleValidationService {

    @Override
    public boolean isValid(UserRole role) {
        return role != null;
    }
}
