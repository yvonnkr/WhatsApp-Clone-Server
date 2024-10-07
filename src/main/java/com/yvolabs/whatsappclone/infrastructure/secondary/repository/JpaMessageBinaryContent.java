package com.yvolabs.whatsappclone.infrastructure.secondary.repository;

import com.yvolabs.whatsappclone.infrastructure.secondary.entity.MessageContentBinaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

public interface JpaMessageBinaryContent extends JpaRepository<MessageContentBinaryEntity, Long> {
}