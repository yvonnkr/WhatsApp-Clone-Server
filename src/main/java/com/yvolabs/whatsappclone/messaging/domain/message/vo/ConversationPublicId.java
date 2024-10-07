package com.yvolabs.whatsappclone.messaging.domain.message.vo;


import org.springframework.util.Assert;

import java.util.UUID;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */
public record ConversationPublicId(UUID value) {
    public ConversationPublicId {
        Assert.notNull(value, "conversation cannot be null");
    }
}
