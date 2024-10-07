package com.yvolabs.whatsappclone.messaging.domain.message.aggregate;



import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.MessageContent;
import org.jilt.Builder;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

@Builder
public record MessageSendNew(MessageContent messageContent,
                             ConversationPublicId conversationPublicId) {
}