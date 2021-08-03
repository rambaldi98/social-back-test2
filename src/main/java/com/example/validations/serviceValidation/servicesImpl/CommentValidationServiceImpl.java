package com.example.validations.serviceValidation.servicesImpl;
import com.example.models.dto.bindingModels.comment.CommentCreateBindingModel;
import com.example.models.entities.Comment;
import com.example.validations.serviceValidation.services.CommentValidationService;
import org.springframework.stereotype.Component;

@Component
public class CommentValidationServiceImpl implements CommentValidationService {
    @Override
    public boolean isValid(Comment comment) {
        return comment != null;
    }

    @Override
    public boolean isValid(CommentCreateBindingModel commentCreateBindingModel) {
        return commentCreateBindingModel != null;
    }
}
