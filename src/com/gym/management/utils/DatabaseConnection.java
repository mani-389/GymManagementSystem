package com.gym.management.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static final String DB_URL = "jdbc:derby://localhost:1527/gym_management_db";
    private static final String USER = "affan";
    private static final String PASS = "affan123";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println(" Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println(" Derby JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(" Connection failed!");
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println(" Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println(" Test successful!");
            closeConnection(conn);
        } else {
            System.out.println(" Test failed!");
        }
    }
}