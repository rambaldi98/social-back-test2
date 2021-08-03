package com.example.validations.serviceValidation.servicesImpl;

import com.example.models.dto.bindingModels.message.MessageCreateBindingModel;
import com.example.validations.serviceValidation.services.MessageValidationService;
import org.springframework.stereotype.Component;

@Component
public class MessageValidationServiceImpl implements MessageValidationService {
    @Override
    public boolean isValid(MessageCreateBindingModel messageCreateBindingModel) {
        return messageCreateBindingModel != null;
    }
}
