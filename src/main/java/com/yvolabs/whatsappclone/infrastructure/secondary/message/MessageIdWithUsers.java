package com.yvolabs.whatsappclone.infrastructure.secondary.message;


import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;

import java.util.List;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 18/10/2024
 */

public record MessageIdWithUsers(ConversationViewedForNotification conversationViewedForNotification,
                                 List<UserPublicId> usersToNotify) {
}
