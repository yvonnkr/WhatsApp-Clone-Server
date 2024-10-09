package com.yvolabs.whatsappclone.infrastructure.primary.user;

import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import org.jilt.Builder;

import java.util.UUID;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 09/10/2024
 */

@Builder
public record RestSearchUser(String lastName,
                             String firstName,
                             String email,
                             UUID publicId,
                             String imageUrl) {

    public static RestSearchUser from(User user) {
        RestSearchUserBuilder restSearchUserBuilder = RestSearchUserBuilder.restSearchUser();

        if (user.getLastName() != null) {
            restSearchUserBuilder.lastName(user.getLastName().value());
        }

        if (user.getFirstname() != null) {
            restSearchUserBuilder.firstName(user.getFirstname().value());
        }

        if (user.getImageUrl() != null) {
            restSearchUserBuilder.imageUrl(user.getImageUrl().value());
        }

        return restSearchUserBuilder.email(user.getEmail().value())
                .publicId(user.getUserPublicId().value())
                .build();
    }
}
