package com.yvolabs.whatsappclone.infrastructure.primary.conversation;



import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import org.jilt.Builder;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 09/10/2024
 */

@Builder
public record RestUserForConversation(String lastName, String firstName,
                                      UUID publicId, String imageUrl,
                                      Instant lastSeen) {

    public static RestUserForConversation from(User user) {
        RestUserForConversationBuilder restUserForConversationBuilder = RestUserForConversationBuilder.restUserForConversation();

        if (user.getImageUrl() != null) {
            restUserForConversationBuilder.imageUrl(user.getImageUrl().value());
        }

        return restUserForConversationBuilder
                .lastName(user.getLastName().value())
                .firstName(user.getFirstname().value())
                .publicId(user.getUserPublicId().value())
                .lastSeen(user.getLastSeen())
                .build();
    }

    public static List<RestUserForConversation> from(Set<User> users) {
        return users.stream().map(RestUserForConversation::from).toList();
    }
}
