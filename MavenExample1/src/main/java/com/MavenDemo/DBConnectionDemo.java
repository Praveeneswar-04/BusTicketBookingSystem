package com.MavenDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionDemo {
    public static void main(String args[]) {
        //url
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";

        //username
        final String username = "system";
        final String password = "Praveen";
        String sql_query = "CREATE TABLE DATABASE.EE (Name VARCHAR2(10), LNAME VARCHAR2(10))"; // Removed DATABASE. from table name
        String s_query="INSERT INTO  DATABASE.EE VALUES('PRAVEEN' ,'ESWAR')";
        String d_query="SELECT *FROM DATABASE.EE";
        //step1 - registering the driver class 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Create Connection
            Connection con = DriverManager.getConnection(url, username, password);

            if (con == null) {
                System.out.println("Not Found");
            } else {
                System.out.println("Found");
            }

            //creating the statement 
            Statement stat = con.createStatement();
            //insert into the values into the element 
           // boolean isCreated = stat.execute(s_query);
             
            //update query
            String update="UPDATE DATABASE.EE SET NAME='SANJAI' WHERE NAME ='PRAVEEN'";
            stat.execute(update);
            
            //for displaying the records 
            ResultSet trecords=stat.executeQuery(d_query);
            
            int i=1;
            while (trecords.next()) {
            	System.out.println(trecords.getString(i));
            	i++;
            }     

//            if (isCreated) {
//                System.out.println("Table Created ");
//            } else {
//                System.out.println("Table not Created");
//            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
