package com.univer.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionPooling {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(PropertiesLoader.getProperty("db.url"));
        config.setUsername(PropertiesLoader.getProperty("db.username"));
        config.setPassword(PropertiesLoader.getProperty("db.password"));
        config.setDriverClassName(PropertiesLoader.getProperty("db.driver"));

        // Optional HikariCP settings
        config.setMaximumPoolSize(Integer.parseInt(PropertiesLoader.getProperty("db.pool.maxPoolSize")));
        config.setMinimumIdle(Integer.parseInt(PropertiesLoader.getProperty("db.pool.minIdle")));
        config.setConnectionTimeout(Long.parseLong(PropertiesLoader.getProperty("db.pool.connectionTimeout")));
        config.setIdleTimeout(Long.parseLong(PropertiesLoader.getProperty("db.pool.idleTimeout")));
        config.setMaxLifetime(Long.parseLong(PropertiesLoader.getProperty("db.pool.maxLifetime")));

        dataSource = new HikariDataSource(config);
    }

    private DBConnectionPooling() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
