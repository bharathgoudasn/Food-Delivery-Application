package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.food.DBconnection.DBconnection;
import com.food.controller.Myencrypt;
import com.food.dao.UserDao;
import com.food.model.User;
import com.mysql.cj.xdevapi.Statement;

public class UserDAOimp implements UserDao
{

	
	private static Connection con;
	ArrayList<User> userList=new ArrayList<User>();
	private static final String INSERT="insert into user(username,password,email,address) values(?,?,?,?)";
	private static final String FETCHALL="select * from user";
	private static final String FETCHONE="Select * from user where userid=?";
	private static final String UPDATE="update user set email=? where userid=?";
	private static final String DELETE="delete from user where userid=?";
	private static final String FETCH="Select * from user where email=?";
	static
	{
		con=DBconnection.connect();
	}

	private PreparedStatement pstmt;
	private ResultSet resultSet;
    private java.sql.Statement stmt;
	
	@Override
 public int insert(User u) {
		try
		{
		pstmt=con.prepareStatement(INSERT);
		pstmt.setString(1, u.getUsername());
		pstmt.setString(2, u.getPassword());
		pstmt.setString(3, u.getEmail());
		pstmt.setString(4, u.getAddress());
		
		return pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public ArrayList<User> fetchAll() {
		try
		{
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(FETCHALL);
		return users(resultSet);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<User> users(ResultSet rl){
		try
		{
			while(rl.next())
			{
				userList.add(
						new User(
								rl.getInt("userid"),
								Myencrypt.decrypt(rl.getString("username")),
								Myencrypt.decrypt(rl.getString("password")),
								Myencrypt.decrypt(rl.getString("email")),
								Myencrypt.decrypt(rl.getString("address"))
								)
						);
			}
			return userList;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public User fetchone(int id) {
		try
		{
		pstmt=con.prepareStatement(FETCHONE);
		pstmt.setInt(1,id);
		resultSet=pstmt.executeQuery();
		userList=users(resultSet);
		
		return userList.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public User fetch(String email) {
		
		try
		{
		pstmt=con.prepareStatement(FETCH);
		pstmt.setString(1,email);
		resultSet=pstmt.executeQuery();
		userList=users(resultSet);
		
		return userList.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public int update(int id, String email) {
		try
		{
		pstmt=con.prepareStatement(UPDATE);
		pstmt.setInt(2,id);
		pstmt.setString(1, email);
		
		return pstmt.executeUpdate();
		}
		catch(Exception e)
		{  
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {

		try
		{
		pstmt=con.prepareStatement(DELETE);
		pstmt.setInt(1,id);
		
		return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}	
		
	}


}

