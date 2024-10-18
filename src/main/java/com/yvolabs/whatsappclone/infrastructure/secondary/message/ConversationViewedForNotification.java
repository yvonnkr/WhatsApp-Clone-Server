package com.yvolabs.whatsappclone.infrastructure.secondary.message;

import java.util.List;
import java.util.UUID;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 18/10/2024
 */

public record ConversationViewedForNotification(UUID conversationId,
                                                List<UUID> messageIdsViewed) {
}