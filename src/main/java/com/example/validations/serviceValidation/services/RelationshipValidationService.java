package com.example.validations.serviceValidation.services;


import com.example.models.entities.Relationship;

public interface RelationshipValidationService {
    boolean isValid(Relationship relationship);
}
