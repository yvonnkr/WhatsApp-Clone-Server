package com.yvolabs.whatsappclone.infrastructure.primary.user;

import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import org.jilt.Builder;

import java.util.Set;
import java.util.UUID;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 08/10/2024
 */

@Builder
public record RestUser(UUID publicId,
                       String firstName,
                       String lastName,
                       String email,
                       String imageUrl,
                       Set<RestAuthority> authorities) {

    static RestUser from(User user) {
        RestUserBuilder restUserBuilder = RestUserBuilder.restUser();

        if(user.getImageUrl() != null) {
            restUserBuilder.imageUrl(user.getImageUrl().value());
        }

        return restUserBuilder
                .email(user.getEmail().value())
                .firstName(user.getFirstname().value())
                .lastName(user.getLastName().value())
                .publicId(user.getUserPublicId().value())
                .authorities(RestAuthority.fromSet(user.getAuthorities()))
                .build();
    }
}
