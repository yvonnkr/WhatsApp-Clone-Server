package com.yvolabs.whatsappclone.infrastructure.primary.user;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 08/10/2024
 */

import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.Authority;
import org.jilt.Builder;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
public record RestAuthority(String name) {

    public static Set<RestAuthority> fromSet(Set<Authority> authorities) {
        return authorities.stream()
                .map(authority -> RestAuthorityBuilder
                        .restAuthority()
                        .name(authority.getName().name())
                        .build()
                )
                .collect(Collectors.toSet());
    }

}
