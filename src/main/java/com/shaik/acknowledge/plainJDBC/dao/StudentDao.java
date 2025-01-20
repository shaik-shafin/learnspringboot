package com.shaik.acknowledge.plainJDBC.dao;

import com.shaik.acknowledge.plainJDBC.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {

    public void createStudent(String userName){
        try{
            Connection connection = DatabaseConnection.getConnection();
            String sqlQuery = "INSERT INTO student(student_name) VALUES(?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, userName);
            statement.executeUpdate();
        }catch(SQLException e){
            /*need to close prepare statement and connection*/
            e.printStackTrace();
        }
    }

    public String readStudent(){
        StringBuilder result = new StringBuilder();
        try{
            Connection connection = DatabaseConnection.getConnection();
            String sqlQuery = "SELECT * FROM student";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet output = statement.executeQuery();

            while(output.next()){
                result.append(output.getInt(1)).append(" , ").append(output.getString(2)).append("\n");
            }
        }catch(SQLException e){
            /*need to close prepare statement and connection*/
            e.printStackTrace();
        }

        return result.toString();
    }
}
