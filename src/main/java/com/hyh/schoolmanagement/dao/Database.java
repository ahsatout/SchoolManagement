package com.hyh.schoolmanagement.dao;

import com.hyh.schoolmanagement.config.DatabaseConfigManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static Database instance = null;
    private static final Logger LOGGER = Logger.getLogger(Database.class.getName());

    private Connection con = DatabaseConfigManager.getInstance().getConnection();

    private Database() {}

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    public ResultSet executeQuery(String query) {
        Statement statement = null;
        try {
            statement = con.createStatement();
            return statement.executeQuery(query); // Caller must close ResultSet
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error executing SQL query", e);
            throw new RuntimeException("Query execution failed", e);
        } finally {
           // closeResources(con, statement, null); // Statement and Connection are closed here
        }
    }

    public boolean executeUpdate(String stmnt) {
        Statement statement = null;
        try {
            statement = con.createStatement();
            return statement.executeUpdate(stmnt) > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error executing SQL update", e);
            throw new RuntimeException("Update execution failed", e);
        } finally {
           // closeResources(con, statement, null);
        }
    }
/*
    private void closeResources(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing ResultSet", e);
        }
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing Statement", e);
        }
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing Connection", e);
        }
    }
    */
}
