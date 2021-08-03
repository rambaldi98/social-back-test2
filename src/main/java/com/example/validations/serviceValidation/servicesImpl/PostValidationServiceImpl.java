package com.example.validations.serviceValidation.servicesImpl;

import com.example.models.entities.Post;
import com.example.models.dto.bindingModels.post.PostCreateBindingModel;
import com.example.validations.serviceValidation.services.PostValidationService;
import org.springframework.stereotype.Component;

@Component
public class PostValidationServiceImpl implements PostValidationService {
    @Override
    public boolean isValid(Post post) {
        return post != null;
    }

    @Override
    public boolean isValid(PostCreateBindingModel postCreateBindingModel) {
        return postCreateBindingModel != null;
    }
}
