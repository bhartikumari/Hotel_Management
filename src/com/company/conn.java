package com.company;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn(){
        try {
            //driver register
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///projecthms","root","bhartiB@08");
            s= c.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
