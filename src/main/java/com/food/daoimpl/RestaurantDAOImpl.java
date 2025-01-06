package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.food.DBconnection.DBconnection;
import com.food.dao.RestaurantDAO;
import com.food.model.Restuarant;

public class RestaurantDAOImpl implements RestaurantDAO
{
	
	
	private static Connection con;
	ArrayList<Restuarant> list=new ArrayList<Restuarant>();
	private static final String INSERT="insert into Restaurant(Restaurantid,Name,Cuisinetype,Deliverytime,address,Rating,Isactive,imagepath) values(?,?,?,?,?,?,?,?)";
	private static final String FETCHALL="select * from Restaurant";
	private static final String FETCHONE="Select * from Restaurant where Restaurantid=?";
	private static final String UPDATE="update Restaurant set Rating=? where Restaurantid=?";
	private static final String DELETE="delete from Restaurant where Restaurantid=?";
	static
	{
		con=DBconnection.connect();
	}

	private PreparedStatement pstmt;
	private java.sql.Statement stmt;
	private ResultSet resultSet;
	
	@Override
 public int insert(Restuarant  r) {
		try
		{
		pstmt=con.prepareStatement(INSERT);
		pstmt.setInt(1,r.getRestaurantId());
		pstmt.setString(2, r.getName());
		pstmt.setString(3, r.getCuisineType());
		pstmt.setInt(4, r.getDeliveryTime());
		pstmt.setString(5, r.getAddress());
		pstmt.setFloat(6, r.getRating());
		pstmt.setString(7, r.isActive());
		pstmt.setString(8, r.getImagePath());
		
		return pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public ArrayList<Restuarant > fetchAll() {
		try
		{
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(FETCHALL);
		return restaurants(resultSet);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Restuarant > restaurants(ResultSet rl){
		try
		{
			while(rl.next())
			{
				list.add(
						new Restuarant(
								rl.getInt("Restaurantid"),
								rl.getString("Name"),
								rl.getString("Cuisinetype"),
								rl.getInt("Deliverytime"),
								rl.getString("Address"),
								rl.getFloat("Rating"),
								rl.getString("Isactive"),
								rl.getString("imagepath")
								)
						);
			}
			return list;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Restuarant fetchOne(int id) {
		try
		{
		pstmt=con.prepareStatement(FETCHONE);
		pstmt.setInt(1,id);
		resultSet=pstmt.executeQuery();
		list=restaurants(resultSet);
		
		return list.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public int update(int id, float rating) {
		try
		{
		pstmt=con.prepareStatement(UPDATE);
		pstmt.setInt(2,id);
		pstmt.setFloat(1, rating);
		
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
