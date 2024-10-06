package com.yvolabs.whatsappclone.shared.authentication.domain;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 06/10/2024
 */
import com.yvolabs.whatsappclone.shared.error.domain.Assert;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public record Username(String username) {
    public Username {
        Assert.field("username", username).notBlank().maxLength(100);
    }

    public String get() {
        return username();
    }

    public static Optional<Username> of(String username) {
        return Optional.ofNullable(username).filter(StringUtils::isNotBlank).map(Username::new);
    }
}
