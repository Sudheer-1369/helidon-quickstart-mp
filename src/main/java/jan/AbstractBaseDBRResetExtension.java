/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package jan;

import io.helidon.microprofile.cdi.HelidonContainer;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Set;

public abstract class AbstractBaseDBRResetExtension implements BeforeEachCallback {

    protected static final String schema = "DECS_OWNER";
    protected final System.Logger logger = System.getLogger(getClass().getName());

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {

        var dataSource = HelidonContainer.instance().start().select(DataSource.class).get();
        try (Connection connection = dataSource.getConnection()) {

            disableReferentialIntegrity(connection);

            var tables = resetTables(connection);
            var sequences = resetSequences(connection);

            logger.log(
                    System.Logger.Level.DEBUG,
                    () ->
                            String.format(
                                    "Tables cleared=%s%s",
                                    tables,
                                    sequences.size() == 0
                                            ? ""
                                            : String.format(", Sequences adjusted=%s", sequences)));

            enableReferentialIntegrity(connection);
        }
    }

    protected abstract void disableReferentialIntegrity(Connection connection) throws SQLException;

    protected abstract void enableReferentialIntegrity(Connection connection) throws SQLException;

    protected abstract Set<String> resetTables(Connection connection) throws SQLException;

    protected Set<String> resetSequences(Connection connection) throws SQLException {
        return Collections.emptySet();
    }
}

