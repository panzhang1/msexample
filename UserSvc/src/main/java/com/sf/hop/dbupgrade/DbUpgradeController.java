package com.sf.hop.dbupgrade;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbUpgradeController {
    private static final Logger LOG = LoggerFactory.getLogger(DbUpgradeController.class);

    @Autowired
    private Flyway flyway;

    @GetMapping(value = "/upgrade/{schema}")
    public boolean upgrade(@PathVariable(value="schema") String schema) {
        LOG.info(String.format("-----------upgrade for :%s", schema));
        flyway.migrate();
        return true;
    }

    @GetMapping(value = "/repair/{schema}")
    public boolean repair(@PathVariable(value="schema") String schema) {
        LOG.info(String.format("-----------repair for :%s", schema));
        flyway.repair();
        return true;
    }
}