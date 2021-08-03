package com.example.validations.serviceValidation.services;
import com.example.models.dto.bindingModels.comment.CommentCreateBindingModel;
import com.example.models.entities.Comment;

public interface CommentValidationService {
    boolean isValid(Comment comment);

    boolean isValid(CommentCreateBindingModel commentCreateBindingModel);
}
