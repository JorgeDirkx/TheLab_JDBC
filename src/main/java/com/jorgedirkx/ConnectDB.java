package com.jorgedirkx;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static void main(String[] args) {

        //testing the thorius_db connection with JDBC
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thorius_db?serverTimezone=UTC","root","Doreen1")){
            System.out.println("connection OK");
        }
        catch (Exception e){
            System.out.println("debug !, something went wrong");

        }
    }
}
