package com.yvolabs.whatsappclone.messaging.domain.user.vo;

import com.yvolabs.whatsappclone.shared.error.domain.Assert;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */
public record AuthorityName(String name) {

    public AuthorityName {
        Assert.field("name", name).notNull();
    }
}
