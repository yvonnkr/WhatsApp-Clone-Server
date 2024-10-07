package com.yvolabs.whatsappclone.messaging.domain.message.vo;

import com.yvolabs.whatsappclone.shared.error.domain.Assert;

import java.time.Instant;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */
public record MessageSentTime(Instant date) {
    public MessageSentTime {
        Assert.field("date", date).notNull();
    }
}
