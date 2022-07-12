/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package jan;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/** JUnit5 extension that when applied to a class will reset H2 database state to 'empty'. */
public class H2DbResetExtension extends AbstractBaseDBRResetExtension {
    private static final String SQL_DISABLE_REFERENTIAL_INTEGRITY = "SET REFERENTIAL_INTEGRITY FALSE";
    private static final String SQL_ENABLE_REFERENTIAL_INTEGRITY = "SET REFERENTIAL_INTEGRITY TRUE";

    private static final String SQL_FIND_TABLE_NAMES =
            "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='%s' AND TABLE_TYPE != 'VIEW'";
    private static final String SQL_TRUNCATE_TABLE = "TRUNCATE TABLE %s.%s";

    private static final String SQL_FIND_SEQUENCE_NAMES =
            "SELECT SEQUENCE_NAME FROM INFORMATION_SCHEMA.SEQUENCES WHERE SEQUENCE_SCHEMA='%s'";
    private static final String SQL_RESTART_SEQUENCE = "ALTER SEQUENCE %s.%s RESTART WITH 1";

    @Override
    protected void disableReferentialIntegrity(Connection connection) throws SQLException {
        try (var statement = connection.createStatement()) {
            statement.execute(SQL_DISABLE_REFERENTIAL_INTEGRITY);
        }
    }

    @Override
    protected void enableReferentialIntegrity(Connection connection) throws SQLException {
        try (var statement = connection.createStatement()) {
            statement.execute(SQL_ENABLE_REFERENTIAL_INTEGRITY);
        }
    }

    @Override
    protected Set<String> resetTables(Connection connection) throws SQLException {
        try (var statement = connection.createStatement()) {
            return reset(statement, SQL_FIND_TABLE_NAMES, SQL_TRUNCATE_TABLE);
        }
    }

    @Override
    protected Set<String> resetSequences(Connection connection) throws SQLException {
        try (var statement = connection.createStatement()) {
            return reset(statement, SQL_FIND_SEQUENCE_NAMES, SQL_RESTART_SEQUENCE);
        }
    }

    private Set<String> reset(Statement statement, String findStatement, String resetStatement)
            throws SQLException {

        Set<String> items = new HashSet<>();
        try (ResultSet resultSet = statement.executeQuery(String.format(findStatement, schema))) {
            while (resultSet.next()) {
                items.add(resultSet.getString(1));
            }
        }

        for (String item : items) {
            statement.executeUpdate(String.format(resetStatement, schema, item));
        }

        return items;
    }
}

