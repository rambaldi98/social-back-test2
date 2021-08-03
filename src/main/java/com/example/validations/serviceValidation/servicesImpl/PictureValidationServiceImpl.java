package com.example.validations.serviceValidation.servicesImpl;

import com.example.models.entities.Picture;
import com.example.validations.serviceValidation.services.PictureValidationService;
import org.springframework.stereotype.Component;

@Component
public class PictureValidationServiceImpl implements PictureValidationService {
    @Override
    public boolean isValid(Picture picture) {
        return picture != null;
    }
}
