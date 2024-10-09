package com.yvolabs.whatsappclone.messaging.application;

import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.Conversation;
import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.ConversationToCreate;
import com.yvolabs.whatsappclone.messaging.domain.message.repository.ConversationRepository;
import com.yvolabs.whatsappclone.messaging.domain.message.repository.MessageRepository;
import com.yvolabs.whatsappclone.messaging.domain.message.service.*;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import com.yvolabs.whatsappclone.messaging.domain.user.repository.UserRepository;
import com.yvolabs.whatsappclone.messaging.domain.user.service.UserReader;
import com.yvolabs.whatsappclone.shared.service.State;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 09/10/2024
 */

@Service
public class ConversationsApplicationService {


    private final ConversationCreator conversationCreator;
    private final ConversationReader conversationReader;
    private final ConversationDeleter conversationDeleter;
    private final UsersApplicationService usersApplicationService;
//    private final ConversationViewed conversationViewed; //TODO

    public ConversationsApplicationService(ConversationRepository conversationRepository,
                                           UserRepository userRepository,
                                           MessageChangeNotifier messageChangeNotifier,
                                           MessageRepository messageRepository,
                                           UsersApplicationService usersApplicationService) {
        UserReader userReader = new UserReader(userRepository);
        this.conversationCreator = new ConversationCreator(conversationRepository, userReader);
        this.conversationReader = new ConversationReader(conversationRepository);
        this.conversationDeleter = new ConversationDeleter(conversationRepository, messageChangeNotifier);
        this.usersApplicationService = usersApplicationService;
//        this.conversationViewed = new ConversationViewed(messageRepository, messageChangeNotifier, userReader);
    }

    @Transactional
    public State<Conversation, String> create(ConversationToCreate conversation) {
        User authenticatedUser = usersApplicationService.getAuthenticatedUser();
        return conversationCreator.create(conversation, authenticatedUser);
    }

    @Transactional(readOnly = true)
    public List<Conversation> getAllByConnectedUser(Pageable pageable) {
        User authenticatedUser = usersApplicationService.getAuthenticatedUser();
        return this.conversationReader.getAllByUserPublicID(authenticatedUser.getUserPublicId(), pageable)
                .stream().toList();
    }

    @Transactional
    public State<ConversationPublicId, String> delete(ConversationPublicId conversationPublicId) {
        User authenticatedUser = usersApplicationService.getAuthenticatedUser();
        return this.conversationDeleter.deleteById(conversationPublicId, authenticatedUser);
    }

    @Transactional(readOnly = true)
    public Optional<Conversation> getOneByConversationId(ConversationPublicId conversationPublicId) {
        User authenticatedUser = usersApplicationService.getAuthenticatedUser();
        return this.conversationReader.getOneByPublicIdAndUserId(conversationPublicId, authenticatedUser.getUserPublicId());
    }

    //TODO
//    @Transactional
//    public State<Integer, String> markConversationAsRead(ConversationPublicId conversationPublicId) {
//        User authenticatedUser = usersApplicationService.getAuthenticatedUser();
//        return conversationViewed.markAsRead(conversationPublicId, authenticatedUser.getUserPublicId());
//    }
}