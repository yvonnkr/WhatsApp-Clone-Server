package com.yvolabs.whatsappclone.infrastructure.secondary.message;

import com.yvolabs.whatsappclone.messaging.domain.message.aggregate.Message;
import com.yvolabs.whatsappclone.messaging.domain.message.service.MessageChangeNotifier;
import com.yvolabs.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;
import com.yvolabs.whatsappclone.shared.service.State;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 09/10/2024
 */

@Service
public class SpringEventMessageChangeNotifier implements MessageChangeNotifier {

    // TODO

    @Override
    public State<Void, String> send(Message message, List<UserPublicId> userToNotify) {
        return null;
    }

    @Override
    public State<Void, String> delete(ConversationPublicId conversationPublicId, List<UserPublicId> userToNotify) {
        return null;
    }


}