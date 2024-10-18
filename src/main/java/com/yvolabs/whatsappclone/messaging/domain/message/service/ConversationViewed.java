package com.yvolabs.whatsappclone.messaging.domain.message.service;

import com.yvolabs.whatsappclone.infrastructure.secondary.message.ConversationViewedForNotification;
import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.Message;
import com.yvolabs.whatsappclone.messaging.domain.message.repository.MessageRepository;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.MessageSendState;
import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import com.yvolabs.whatsappclone.messaging.domain.user.service.UserReader;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;
import com.yvolabs.whatsappclone.shared.service.State;

import java.util.List;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 18/10/2024
 */

public class ConversationViewed {

    private final MessageRepository messageRepository;
    private final MessageChangeNotifier messageChangeNotifier;
    private final UserReader userReader;

    public ConversationViewed(MessageRepository messageRepository, MessageChangeNotifier messageChangeNotifier, UserReader userReader) {
        this.messageRepository = messageRepository;
        this.messageChangeNotifier = messageChangeNotifier;
        this.userReader = userReader;
    }

    public State<Integer, String> markAsRead(ConversationPublicId conversationPublicId, UserPublicId connectedUserPublicId) {
        List<Message> messageToUpdateSendState = messageRepository.findMessageToUpdateSendState(conversationPublicId, connectedUserPublicId);
        int nbUpdatedMessages = messageRepository.updateMessageSendState(conversationPublicId, connectedUserPublicId, MessageSendState.READ);
        List<UserPublicId> usersToNotify = userReader.findUsersToNotify(conversationPublicId, connectedUserPublicId)
                .stream().map(User::getUserPublicId).toList();
        ConversationViewedForNotification conversationViewedForNotification = new ConversationViewedForNotification(
                conversationPublicId.value(),
                messageToUpdateSendState.stream()
                        .map(message -> message.getPublicId().value())
                        .toList()
        );
        messageChangeNotifier.view(conversationViewedForNotification, usersToNotify);

        if (nbUpdatedMessages > 0) {
            return State.<Integer, String>builder().forSuccess(nbUpdatedMessages);
        } else {
            return State.<Integer, String>builder().forSuccess();
        }
    }
}
