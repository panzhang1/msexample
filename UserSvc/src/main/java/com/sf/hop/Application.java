package com.sf.hop;

import com.sf.hop.config.DbPoolConfig;
import com.sf.hop.config.PlatformJwtProperties;
import com.sf.hop.dbupgrade.DisableAutoFlywayMigration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * It can only scan the component under this package
 *
 */
@SpringBootApplication
@EnableConfigurationProperties({PlatformJwtProperties.class, DbPoolConfig.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return new DisableAutoFlywayMigration();
    }
}