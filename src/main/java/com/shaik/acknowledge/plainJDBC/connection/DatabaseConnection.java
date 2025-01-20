package com.shaik.acknowledge.plainJDBC.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "password");
            return connection;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
