package com.food.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

	static Connection con;
	static String url="jdbc:mysql://localhost:3306/foodapplication";
	static String username="root";
	static String password="root";
	
	public static Connection connect()
	{
		try
		{
		//loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish th connection
		con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}