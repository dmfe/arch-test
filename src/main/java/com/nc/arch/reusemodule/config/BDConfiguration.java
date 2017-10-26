package com.nc.arch.reusemodule.config;

import java.sql.Connection;
import java.sql.SQLException;

public class BDConfiguration extends AbstractConfiguration {
    public static final String DEFAULT_TABLE_NAME = "XYZ_MODULE_CONFIG";

    public BDConfiguration(Connection dbConnection) throws SQLException {
        this(dbConnection, DEFAULT_TABLE_NAME);
    }

    public BDConfiguration(Connection dbConnection, String tableName) throws SQLException {
        init(dbConnection, tableName);
    }

    private void init(Connection connection, String tableName) throws SQLException {
        // reading configuration from DB.
    }
}