package com.yvolabs.whatsappclone.messaging.domain.message.service;

import com.yvolabs.whatsappclone.infrastructure.secondary.message.ConversationViewedForNotification;
import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.Message;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;
import com.yvolabs.whatsappclone.shared.service.State;

import java.util.List;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 09/10/2024
 */

public interface MessageChangeNotifier {

    State<Void, String> send(Message message, List<UserPublicId> userToNotify);

    State<Void, String> delete(ConversationPublicId conversationPublicId, List<UserPublicId> userToNotify);

    State<Void, String> view(ConversationViewedForNotification conversationViewedForNotification, List<UserPublicId> usersToNotify);
}