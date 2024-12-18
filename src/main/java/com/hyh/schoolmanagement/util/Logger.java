package com.hyh.schoolmanagement.util;



import com.hyh.schoolmanagement.config.DatabaseConfigManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String LOG_FILE_PATH = DatabaseConfigManager.LOG_FILE_PATH; // Path to the log file
    private static Logger instance;


    // Private constructor to prevent instantiation
    private Logger() {}

    // Singleton instance getter
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Synchronized method to write log messages to the file
    public synchronized void writeLog(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(timestamp + " - " + message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }
}

