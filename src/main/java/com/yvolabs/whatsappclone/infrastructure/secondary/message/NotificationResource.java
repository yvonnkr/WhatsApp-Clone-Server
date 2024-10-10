package com.yvolabs.whatsappclone.infrastructure.secondary.message;

import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserEmail;
import com.yvolabs.whatsappclone.shared.authentication.application.AuthenticatedUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 10/10/2024
 */

@RestController
@RequestMapping("/api/sse")
public class NotificationResource {

    private final NotificationService notificationService;

    public NotificationResource(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/subscribe")
    public SseEmitter subscribe() {
        return notificationService.addEmitter(
                new UserEmail(AuthenticatedUser.username().username()));
    }
}