package com.yvolabs.whatsappclone.messaging.domain.user.service;


import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import com.yvolabs.whatsappclone.messaging.domain.user.repository.UserRepository;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;

import java.time.Instant;
import java.util.Optional;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 08/10/2024
 */

public class UserPresence {

    private final UserRepository userRepository;
    private final UserReader userReader;

    public UserPresence(UserRepository userRepository, UserReader userReader) {
        this.userRepository = userRepository;
        this.userReader = userReader;
    }

    public void updatePresence(UserPublicId userPublicId) {
        userRepository.updateLastSeenByPublicId(userPublicId, Instant.now());
    }

    public Optional<Instant> getLastSeenByPublicId(UserPublicId userPublicId) {
        Optional<User> byPublicId = userReader.getByPublicId(userPublicId);
        return byPublicId.map(User::getLastSeen);
    }
}
