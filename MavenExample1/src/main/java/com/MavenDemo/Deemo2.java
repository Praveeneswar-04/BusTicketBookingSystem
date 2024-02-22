package com.MavenDemo;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class Deemo2 {
	    public static void main(String args[]) {
	    	
	    	Scanner sc=new Scanner(System.in);
	    	
//	    	String name=sc.nextLine();
	//    	int number =sc.nextInt();
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
	            
	            Statement s=con.createStatement();
	            
	            String query="Select * from DATABASE.emp";
	            
	            //String query1="Create table "
	            ResultSet rs=s.executeQuery(query);
	            
	            while (rs.next()) {
	            	System.out.println(rs.getString(1));
	            }
}
	        catch(Exception e) {
	        	e.printStackTrace();
	        	}}
	        }
