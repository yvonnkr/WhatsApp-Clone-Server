package com.yvolabs.whatsappclone.shared.authentication.infrastructure.primary;

import com.yvolabs.whatsappclone.shared.authentication.application.AuthenticatedUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import  java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 08/10/2024
 */

public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt source) {
        return new JwtAuthenticationToken(
                source,
                Stream.concat(
                                new JwtGrantedAuthoritiesConverter().convert(source)
                                        .stream(),
                                extractResourceRoles(source).stream()
                        )
                        .collect(Collectors.toSet()));
    }

    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        return AuthenticatedUser.extractRolesFromToken(jwt).stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}
