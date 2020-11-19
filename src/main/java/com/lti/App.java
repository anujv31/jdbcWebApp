package com.lti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{	
	Connection con;
	Statement stmt;
	ResultSet rs;
	public App(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","system");
			stmt=con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getAccountDetails(){
		try {
			rs = stmt.executeQuery("select * from emp_jdbc");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+ " " + rs.getString(3));
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
