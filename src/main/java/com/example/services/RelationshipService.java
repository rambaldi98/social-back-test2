package com.example.services;


import com.example.models.dto.serviceModels.RelationshipServiceModel;
import com.example.models.dto.viewModels.relationship.FriendsCandidatesViewModel;

import java.util.List;

public interface RelationshipService {

    List<RelationshipServiceModel> findAllUserRelationshipsWithStatus(String userId) throws Exception;

    List<FriendsCandidatesViewModel> findAllFriendCandidates(String loggedInUserId);

    boolean createRequestForAddingFriend(String loggedInUserId, String friendCandidateId) throws Exception;

    boolean removeFriend(String loggedInUserId, String friendToRemoveId) throws Exception;

    boolean acceptFriend(String loggedInUserId, String friendToAcceptId) throws Exception;

    boolean cancelFriendshipRequest(String loggedInUserId, String friendToRejectId) throws Exception;

    List<FriendsCandidatesViewModel> searchUsers(String loggedInUserId, String search);
}
