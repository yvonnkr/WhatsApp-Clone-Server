package com.yvolabs.whatsappclone.wire.security.infrastructure.primary;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 06/10/2024
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsFilterConfiguration {

    private final CorsConfiguration corsConfiguration;

    public CorsFilterConfiguration(CorsConfiguration corsConfiguration) {
        this.corsConfiguration = corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", corsConfiguration);
        source.registerCorsConfiguration("/**", corsConfiguration);
        source.registerCorsConfiguration("http://localhost:4200", corsConfiguration);
        return new CorsFilter(source);
    }
}