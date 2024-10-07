package com.yvolabs.whatsappclone.messaging.domain.user.aggregate;

import com.yvolabs.whatsappclone.messaging.domain.user.vo.AuthorityName;
import com.yvolabs.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

@Builder
public class Authority {

    private AuthorityName name;

    public Authority(AuthorityName name) {
        Assert.notNull("name", name);
        this.name = name;
    }

    public AuthorityName getName() {
        return name;
    }
}
