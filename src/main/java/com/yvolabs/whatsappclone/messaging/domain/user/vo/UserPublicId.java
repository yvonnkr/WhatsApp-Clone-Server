package com.yvolabs.whatsappclone.messaging.domain.user.vo;


import org.springframework.util.Assert;

import java.util.UUID;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

public record UserPublicId(UUID value) {
    public UserPublicId {
        Assert.notNull(value, "value cannot be null");
    }
}