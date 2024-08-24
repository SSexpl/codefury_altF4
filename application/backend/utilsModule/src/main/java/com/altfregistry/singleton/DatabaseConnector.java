package com.altfregistry.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Connection Provider Class : SPR -> Manager MySQL connection
// Implements AutoCloseable, Closeable so that resource can be used inside a try catch block


public class DatabaseConnector {

    private final static String connectionUrl = "jdbc:mysql://localhost:3306/havenhive";
    private static Connection cnx;

    static {
        cnx = null;
    }

    public static Connection getConnection(){
        // Establishing the connection only if cnx is null
        if ( cnx == null){

            // Registering the mysql Type 4 Driver
            try {

                DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());
                // Providing database URL, database userName and Password
                cnx = DriverManager.getConnection( connectionUrl , "havenuser", "rootpwd");

            } catch (SQLException e) {
                Log.writeToError(e.getMessage() + " " + e.getErrorCode());
            }

        }

        return cnx;
    }

    public static void closeConnection(){
        // Closing the connection only if cnx is not null
        if ( cnx != null){

            // Closing Connection and assigning connection null value
            try {
                cnx.close();
                cnx = null;

            } catch (SQLException e) {
                Log.writeToError(e.getMessage() + " " + e.getErrorCode());
            }

        }
    }

}