/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package com.oracle.hibernate.decs.dao;

import io.helidon.microprofile.cdi.HelidonContainer;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbExtension implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {


        var datasource = HelidonContainer.instance().start().select(DataSource.class).get();

        Connection connection = datasource.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM INFORMATION_SCHEMA");

        while (resultSet.next()) {
            System.out.println(resultSet);
        }

    }
}
