package com.yvolabs.whatsappclone.messaging.domain.message.vo;

import org.jilt.Builder;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 07/10/2024
 */

@Builder
public record MessageContent(String text,
                             MessageType type,
                             MessageMediaContent media) {
}
