package com.banking.atm.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnection {

	Connection con;
	Statement stm;
	public JdbcConnection(){
		
		try {
			
		    //1.registor to mysql driver class
			//Class.forName("com.mysql.jdbc.Driver");
			//2.create connection
			String url = "jdbc:mysql://localhost:3306/Banking_Managment_System";
			String userName = "root";
			String password = "arun123";
			Connection con = DriverManager.getConnection(url,userName,password);
			System.out.println("connect succesfully to database");		
			//3.create statement
			stm = con.createStatement();
		} catch(Exception e) {
			
			System.out.println(e);
		}
		
		
	}
}
