package com.example.validations.serviceValidation.services;

import com.example.models.entities.Post;
import com.example.models.dto.bindingModels.post.PostCreateBindingModel;

public interface PostValidationService {
    boolean isValid(Post post);

    boolean isValid(PostCreateBindingModel postCreateBindingModel);
}

