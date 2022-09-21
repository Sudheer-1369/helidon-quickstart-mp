/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package jan;


//import com.mysql.cj.jdbc.JdbcConnection;

import io.helidon.microprofile.cdi.HelidonContainer;
import liquibase.Liquibase;
import liquibase.Scope;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.ui.LoggerUIService;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;


/**
 * This JUnit5 extension loads an initial data set to test data access for a particular 'entity'.
 * The convention here is that whenever the system finds a (Liquibase) XML file for the test it will
 * run that change set. As an example:
 *
 * <pre>
 *     Test class: ExceptionDefinitionDaoTest.class, this extension will look for
 *     Candidate Liquibase: /setup/ExceptionDefinitionDaoTest.xml
 * </pre>
 * <p>
 * The /setup location should be located in /src/test/resources. Expected use is to list this
 * extension in the JUnit5 test <strong>after</strong> an extension that clears/recreates the
 * original database. For example as is done in {@link H2DbResetExtension}.
 */
public class DbSetupTestExtension implements BeforeEachCallback {

    private final System.Logger logger = System.getLogger(getClass().getName());

    @Override
    public void beforeEach(ExtensionContext context) {

        Optional<Class<?>> testClass = context.getTestClass();
        var candidate = testClass.map(this::liquibaseResource).orElse(null);
        var dataSource = HelidonContainer.instance().start().select(DataSource.class).get();

        testClass
                .map(c -> c.getResource(candidate))
                .ifPresent(i -> runLiquibase(dataSource, context, candidate));
    }

    private void runLiquibase(DataSource dataSource, ExtensionContext context, String script) {
        try (Liquibase liquibase =
                     new Liquibase(
                             script,
                             new ClassLoaderResourceAccessor(),
                             new JdbcConnection(dataSource.getConnection()))) {

            // Adding this, we avoid Liquibase 'polluting' system.out
            // See also: https://github.com/liquibase/liquibase/issues/2396
            Scope.enter(Map.of(Scope.Attr.ui.name(), new LoggerUIService()));

            liquibase.update(context.getDisplayName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String liquibaseResource(Class<?> c) {
        return String.format("/setup/%s.xml", c.getSimpleName());
    }
}

