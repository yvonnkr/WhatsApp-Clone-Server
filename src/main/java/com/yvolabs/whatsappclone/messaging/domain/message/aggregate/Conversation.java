package com.yvolabs.whatsappclone.messaging.domain.message.aggregate;

import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationName;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import com.yvolabs.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;

import java.util.Set;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

@Builder
public class Conversation {
    private final Set<Message> messages;
    private final Set<User> members;
    private final ConversationPublicId conversationPublicId;
    private final ConversationName conversationName;
    private Long dbId;

    public Conversation(Set<Message> messages, Set<User> members, ConversationPublicId conversationPublicId, ConversationName conversationName, Long dbId) {
        assertMandatoryFields(members, conversationName);
        this.messages = messages;
        this.members = members;
        this.conversationPublicId = conversationPublicId;
        this.conversationName = conversationName;
        this.dbId = dbId;
    }

    private void assertMandatoryFields(Set<User> users, ConversationName name) {
        Assert.notNull("users", users);
        Assert.notNull("name", name);
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public Set<User> getMembers() {
        return members;
    }

    public ConversationPublicId getConversationPublicId() {
        return conversationPublicId;
    }

    public ConversationName getConversationName() {
        return conversationName;
    }

    public Long getDbId() {
        return dbId;
    }
}
