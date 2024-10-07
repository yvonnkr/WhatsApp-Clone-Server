package com.yvolabs.whatsappclone.infrastructure.secondary.repository;


import com.yvolabs.whatsappclone.infrastructure.secondary.entity.ConversationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

public interface JpaConversationRepository extends JpaRepository<ConversationEntity, Long> {

    Page<ConversationEntity> findAllByUsersPublicId(UUID publicId, Pageable pageable);

    int deleteByUsersPublicIdAndPublicId(UUID userPublicId, UUID conversationPublicId);

    Optional<ConversationEntity> findOneByUsersPublicIdAndPublicId(UUID userPublicId, UUID conversationPublicId);

    @Query("SELECT conversation FROM ConversationEntity conversation " +
            "JOIN conversation.users users " +
            "WHERE users.publicId IN :userPublicIds " +
            "GROUP BY conversation.id " +
            "HAVING COUNT(users.id) = :userCount")
    Optional<ConversationEntity> findOneByUsersPublicIdIn(List<UUID> userPublicIds, int userCount);

    Optional<ConversationEntity> findOneByPublicId(UUID publicId);
}
