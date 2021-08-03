package com.example.services;

import com.example.models.dto.bindingModels.message.MessageCreateBindingModel;
import com.example.models.dto.serviceModels.MessageServiceModel;
import com.example.models.dto.viewModels.message.MessageFriendsViewModel;

import java.util.List;

public interface MessageService {
    MessageServiceModel createMessage(MessageCreateBindingModel messageCreateBindingModel, String loggedInUsername) throws Exception;

    List<MessageServiceModel> getAllMessages(String loggedInUsername, String chatUserId);

    List<MessageFriendsViewModel> getAllFriendMessages(String loggedInUsername);
}
