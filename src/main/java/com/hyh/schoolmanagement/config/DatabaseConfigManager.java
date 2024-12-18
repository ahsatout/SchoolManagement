package com.hyh.schoolmanagement.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConfigManager {
    private static DatabaseConfigManager instance;
    private static final Logger LOGGER = Logger.getLogger(DatabaseConfigManager.class.getName());

    private String jdbcUrl;
    private String username;
    private String password;
    private String driverClass;

    public static String LOG_FILE_PATH;


    private DatabaseConfigManager() {
        loadConfiguration();
    }

    public static DatabaseConfigManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConfigManager.class) {
                if (instance == null) {
                    instance = new DatabaseConfigManager();
                }
            }
        }
        return instance;
    }

    private void loadConfiguration() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                LOGGER.severe("Sorry, unable to find database.properties");
                throw new RuntimeException("Configuration file not found");
            }

            props.load(input);
            LOG_FILE_PATH = props.getProperty("log.file");
            jdbcUrl = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");
            driverClass = props.getProperty("db.driver", "com.mysql.cj.jdbc.Driver");
            validateConfiguration();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error reading configuration", ex.getMessage());
            throw new RuntimeException("Failed to load database configuration", ex);
        }
    }

    private void validateConfiguration() {
        if (jdbcUrl == null || jdbcUrl.isEmpty()) {
            throw new IllegalStateException("Database URL cannot be null or empty");
        }
        if (username == null || username.isEmpty()) {
            throw new IllegalStateException("Database username cannot be null or empty");
        }
    }

    public Connection getConnection() {
        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Database driver not found", e);
            throw new RuntimeException("Database driver not found", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to connect to database", e);
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
