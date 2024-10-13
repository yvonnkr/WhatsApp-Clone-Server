package com.yvolabs.whatsappclone.infrastructure.primary.user;

import com.yvolabs.whatsappclone.messaging.application.UsersApplicationService;
import com.yvolabs.whatsappclone.messaging.domain.user.aggregate.User;
import com.yvolabs.whatsappclone.messaging.domain.user.vo.UserPublicId;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 08/10/2024
 */

@RestController
@RequestMapping("/api/users")
public class UsersResource {

    private final UsersApplicationService usersApplicationService;

    public UsersResource(UsersApplicationService usersApplicationService) {
        this.usersApplicationService = usersApplicationService;
    }

    @GetMapping("/get-authenticated-user")
    public ResponseEntity<RestUser> getAuthenticatedUser(@AuthenticationPrincipal Jwt user,
                                                         @RequestParam boolean forceResync) {
        User authenticatedUser = usersApplicationService.getAuthenticatedUserWithSync(user, forceResync);
        RestUser restUser = RestUser.from(authenticatedUser);
        return ResponseEntity.ok(restUser);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RestSearchUser>> search(Pageable pageable, @RequestParam String query) {
        List<RestSearchUser> searchResults = usersApplicationService.search(pageable, query)
                .stream().map(RestSearchUser::from)
                .toList();
        return ResponseEntity.ok(searchResults);
    }

    @GetMapping("/get-last-seen")
    ResponseEntity<Instant> getLastSeen(@RequestParam UUID publicId) {
        Optional<Instant> lastSeen = usersApplicationService.getLastSeen(new UserPublicId(publicId));
        if (lastSeen.isPresent()) {
            return ResponseEntity.ok(lastSeen.get());
        } else {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Unable to fetch the presence of the user " + publicId);
            return ResponseEntity.of(problemDetail).build();
        }
    }
}
