package com.yvolabs.whatsappclone.messaging.domain.message.vo;

import com.yvolabs.whatsappclone.shared.error.domain.Assert;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

public record ConversationName(String name) {

    public ConversationName {
        Assert.field("name", name).minLength(3).maxLength(255);
    }
}
