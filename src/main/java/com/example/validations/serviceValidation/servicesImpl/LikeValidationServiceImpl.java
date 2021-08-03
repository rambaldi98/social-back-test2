package com.example.validations.serviceValidation.servicesImpl;

import com.example.models.entities.Like;
import com.example.validations.serviceValidation.services.LikeValidationService;
import org.springframework.stereotype.Component;

@Component
public class LikeValidationServiceImpl implements LikeValidationService {
    @Override
    public boolean isValid(Like like) {
        return like != null;
    }
}
