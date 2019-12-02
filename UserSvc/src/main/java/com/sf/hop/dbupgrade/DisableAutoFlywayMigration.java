package com.sf.hop.dbupgrade;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;

public class DisableAutoFlywayMigration implements FlywayMigrationStrategy {
    private static final Logger LOG = LoggerFactory.getLogger(DisableAutoFlywayMigration.class);
    @Override
    public void migrate(Flyway flyway) {
        //do nothing
        LOG.info("Disable auto flyway migration");
    }
}
