package com.neoteric.fullstackdemo_318._4.service;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class DBConnection {

    public static Connection connection;

    public static Connection getConnection(){
        Connection con=null;

        try {

            if (connection==null) {

                System.out.println("Getting Connection");

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://@localhost:3606/bank",
                        "root", "neoteric");
            }else {
                System.out.println(" returning existing connection");
            }


        }
        catch (Exception e){



        System.out.println("execption occured in getConnection" + e);
       }
        return connection;

    }
}
