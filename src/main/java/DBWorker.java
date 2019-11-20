package main.java;

import java.sql.*;


public class DBWorker {
    /*private final static String URLFIXED = "jdbc:mysql://localhost:3306/mydbtest" +
            "?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";*/
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=UTC";
    private final static String USERNAME = "DBroot";
    private final static String PASSWORD = "***********";

    private Connection connection;

    public DBWorker() {
        try {
           connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
