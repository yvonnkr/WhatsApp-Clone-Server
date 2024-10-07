package com.yvolabs.whatsappclone.messaging.domain.message.aggregate;

import com.yvolabs.whatsappclone.shared.error.domain.Assert;

import java.util.List;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

public record Messages(List<Messages> messages) {
    public Messages {
        Assert.field("messages", messages).notNull().noNullElement();
    }
}
