package com.yvolabs.whatsappclone.messaging.domain.message.repository;

import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.Conversation;
import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.Message;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.MessageSendState;
import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;

import java.util.List;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

public interface MessageRepository {
    Message save(Message message, User sender, Conversation conversation);

    int updateMessageSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId, MessageSendState state);

    List<Message> findMessageToUpdateSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId);
}
