package com.yvolabs.whatsappclone.infrastructure.secondary.message;

import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;

import java.util.List;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 10/10/2024
 */

public record ConversationIdWithUsers(ConversationPublicId conversationPublicId,
                                      List<UserPublicId> users) {
}
