package com.yvolabs.whatsappclone.wire.postgresql.infrastructure;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 06/10/2024
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.yvolabs.whatsappclone"})
@EnableJpaAuditing
public class DatabaseConfiguration {
}
