package com.yvolabs.whatsappclone.infrastructure.secondary.message;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 10/10/2024
 */
public enum NotificationEventName {
    NEW_MESSAGE("message"), DELETE_CONVERSATION("delete-conversation"),
    VIEWS_MESSAGES("view-messages");

    final String value;

    NotificationEventName(String value) {
        this.value = value;
    }
}