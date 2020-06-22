package com.jorgedirkx;

import java.lang.module.ResolutionException;
import java.sql.*;

public class ConnectDB {
    public static void main(String[] args) {

        String sql = "SELECT * FROM project";

        String sqlUpdate = "UPDATE project SET name='to be determined' WHERE Id =1";

        String sqlAddData = "INSERT INTO project(name)" + "VALUES('Project 2')";

        //testing the thorius_db connection with JDBC
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thorius_db?serverTimezone=UTC","root","Doreen1");

            /*Statement statement = conn.createStatement()){
            int result = statement.executeUpdate(sqlUpdate);
            int result2 = statement.executeUpdate(sqlAddData); */


            //resultset can be read all directions and resultset can be updated
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //request data from db
            ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()){
                String name = rs.getString("name");
                System.out.format("%s\n", name);




        }
            rs.close();



        System.out.println("connection OK");


        }
        catch (Exception e){
            e.printStackTrace();
            /*System.out.println("debug !, something went wrong");*/

        }
    }
}
