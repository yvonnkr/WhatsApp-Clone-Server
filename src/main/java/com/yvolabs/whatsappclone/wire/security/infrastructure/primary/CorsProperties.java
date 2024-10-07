package com.yvolabs.whatsappclone.wire.security.infrastructure.primary;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;


/**
 * @author Yvonne N
 * @version 1.0
 * @since 06/10/2024
 */

@Configuration
public class CorsProperties {

    @Bean
    @ConfigurationProperties(prefix = "application.cors", ignoreUnknownFields = false)
    public CorsConfiguration corsConfiguration() {
        return new CorsConfiguration();
    }
}