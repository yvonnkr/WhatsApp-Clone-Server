package com.yvolabs.whatsappclone.infrastructure.secondary.repository;


import com.yvolabs.whatsappclone.infrastructure.secondary.entity.ConversationEntity;
import com.yvolabs.whatsappclone.infrastructure.secondary.entity.MessageEntity;
import com.yvolabs.whatsappclone.infrastructure.secondary.entity.UserEntity;
import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.Conversation;
import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.Message;
import com.yvolabs.whatsappclone.messaging.domain.message.repository.MessageRepository;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.MessageSendState;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.MessageType;
import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

@Repository
public class SpringDataMessageRepository implements MessageRepository {

    private final JpaMessageRepository jpaMessageRepository;
    private final JpaMessageBinaryContent jpaMessageBinaryContent;

    public SpringDataMessageRepository(JpaMessageRepository jpaMessageRepository, JpaMessageBinaryContent jpaMessageBinaryContent) {
        this.jpaMessageRepository = jpaMessageRepository;
        this.jpaMessageBinaryContent = jpaMessageBinaryContent;
    }

    @Override
    public Message save(Message message, User sender, Conversation conversation) {
        MessageEntity messageEntity = MessageEntity.from(message);
        messageEntity.setSender(UserEntity.from(sender));
        messageEntity.setConversation(ConversationEntity.from(conversation));

        if (message.getContent().type() != MessageType.TEXT) {
            jpaMessageBinaryContent.save(messageEntity.getContentBinary());
        }

        MessageEntity messageSaved = jpaMessageRepository.save(messageEntity);
        return MessageEntity.toDomain(messageSaved);
    }

    @Override
    public int updateMessageSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId, MessageSendState state) {
        return jpaMessageRepository.updateMessageSendState(conversationPublicId.value(), userPublicId.value(), state);
    }

    @Override
    public List<Message> findMessageToUpdateSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId) {
        return jpaMessageRepository.findMessageToUpdateSendState(conversationPublicId.value(), userPublicId.value())
                .stream().map(MessageEntity::toDomain).toList();
    }
}