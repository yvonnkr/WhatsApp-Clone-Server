package com.yvolabs.whatsappclone.messaging.domain.user.vo;

import com.yvolabs.whatsappclone.shared.error.domain.Assert;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

public record UserImageUrl(String value) {

    public UserImageUrl {
        Assert.field(value, value).maxLength(255);
    }
}
