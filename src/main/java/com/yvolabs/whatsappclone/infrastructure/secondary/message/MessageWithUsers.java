package com.yvolabs.whatsappclone.infrastructure.secondary.message;


import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.Message;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;

import java.util.List;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 13/10/2024
 */

public record MessageWithUsers(Message message, List<UserPublicId> userToNotify) {
}