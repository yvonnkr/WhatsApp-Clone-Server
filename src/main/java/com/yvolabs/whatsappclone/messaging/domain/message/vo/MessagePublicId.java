package com.yvolabs.whatsappclone.messaging.domain.message.vo;


import org.springframework.util.Assert;

import java.util.UUID;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

public record MessagePublicId(UUID value) {
    public MessagePublicId {
        Assert.notNull(value, "Id cannot be null");
    }
}
