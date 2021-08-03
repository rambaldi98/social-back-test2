package com.example.validations.serviceValidation.servicesImpl;

import com.example.models.entities.Relationship;
import com.example.validations.serviceValidation.services.RelationshipValidationService;
import org.springframework.stereotype.Component;

@Component
public class RelationshipValidationServiceImpl implements RelationshipValidationService {
    @Override
    public boolean isValid(Relationship relationship) {
        return relationship != null;
    }
}
