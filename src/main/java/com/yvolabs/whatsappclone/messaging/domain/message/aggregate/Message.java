package com.yvolabs.whatsappclone.messaging.domain.message.aggregate;

import com.yvolabs.whatsappclone.messaging.domain.message.vo.*;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;
import com.yvolabs.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

@Builder
public class Message {
    private final MessageSentTime sentTime;

    private final MessageContent content;

    private final MessageSendState sendState;

    private final MessagePublicId publicId;

    private final UserPublicId sender;

    private final ConversationPublicId conversationId;

    public Message(MessageSentTime sentTime, MessageContent content, MessageSendState sendState, MessagePublicId publicId, UserPublicId sender, ConversationPublicId conversationId) {
        assertMandatoryFields(sentTime, content, sendState, publicId, sender, conversationId);
        this.sentTime = sentTime;
        this.content = content;
        this.sendState = sendState;
        this.publicId = publicId;
        this.sender = sender;
        this.conversationId = conversationId;
    }

    private void assertMandatoryFields(MessageSentTime sentTime,
                                       MessageContent content,
                                       MessageSendState state,
                                       MessagePublicId publicId,
                                       UserPublicId sender,
                                       ConversationPublicId conversationId) {
        Assert.notNull("sentTime", sentTime);
        Assert.notNull("content", content);
        Assert.notNull("state", state);
        Assert.notNull("publicId", publicId);
        Assert.notNull("sender", sender);
        Assert.notNull("conversationId", conversationId);
    }

    public MessageSentTime getSentTime() {
        return sentTime;
    }

    public MessageContent getContent() {
        return content;
    }

    public MessageSendState getSendState() {
        return sendState;
    }

    public MessagePublicId getPublicId() {
        return publicId;
    }

    public UserPublicId getSender() {
        return sender;
    }

    public ConversationPublicId getConversationId() {
        return conversationId;
    }
}
