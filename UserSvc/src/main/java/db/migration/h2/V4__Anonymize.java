package db.migration.h2;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V4__Anonymize extends BaseJavaMigration {
    private static final Logger LOG = LoggerFactory.getLogger(V4__Anonymize.class);

    @Override
    public void migrate(Context context) throws Exception {
        LOG.info("running V3__Anonymize.");
    }
}
