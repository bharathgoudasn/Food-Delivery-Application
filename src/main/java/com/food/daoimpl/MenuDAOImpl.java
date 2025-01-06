package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.food.DBconnection.DBconnection;
import com.food.dao.MenuDAO;
import com.food.model.Menu;
import com.mysql.cj.xdevapi.Statement;

public class MenuDAOImpl implements MenuDAO
{
	private static Connection con;
	ArrayList<Menu> list=new ArrayList<Menu>();
	private static final String INSERT="insert into Menu(menuid,restaurantid,Name,description,price,isavailable,imagepath) values(?,?,?,?,?,?,?)";
	private static final String FETCHALL="select * from Menu";
	private static final String FETCHONE="Select * from Menu where menuid=?";
	private static final String FETCHBYRESTURANTID="Select * from Menu where restaurantid=?";
	private static final String UPDATE="update Menu set price=? where menuid=?";
	private static final String DELETE="delete from Menu where menuid=?";
	static
	{
		con=DBconnection.connect();
	}

	private PreparedStatement pstmt;
	private java.sql.Statement stmt;
	private ResultSet resultSet;
	

	@Override
	public int insert(Menu m) {
		try
		{
		pstmt=con.prepareStatement(INSERT);
		pstmt.setInt(1,m.getMenuid());
		pstmt.setInt(2,m.getRestaurantid());
		pstmt.setString(3, m.getName());
		pstmt.setString(4, m.getDescription());
		pstmt.setInt(5, m.getPrice());
		pstmt.setString(6, m.getIsavailable());
		pstmt.setString(7,m.getImagePath());
		
		return pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Menu> fetchAll() {
		try
		{
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(FETCHALL);
		return menus(resultSet);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Menu> menus(ResultSet rl){
		try
		{
			while(rl.next())
			{
				list.add(
						new Menu(
								rl.getInt("menuid"),
								rl.getInt("Restaurantid"),
								rl.getString("Name"),
								rl.getString("Description"),
								rl.getInt("price"),
								rl.getString("isavailable"),
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
	public Menu fetchOne(int id) {
		try
		{
		pstmt=con.prepareStatement(FETCHONE);
		pstmt.setInt(1,id);
		resultSet=pstmt.executeQuery();
		list=menus(resultSet);
		
		return list.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Menu> fetchMenuByRestaurant(int r_id) {
		try
		{
			pstmt=con.prepareStatement(FETCHBYRESTURANTID);
			pstmt.setInt(1,r_id);
			resultSet=pstmt.executeQuery();
			
			return menus(resultSet);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
		
	}

	@Override
	public int update(int id,int price) {
		try
		{
		pstmt=con.prepareStatement(UPDATE);
		pstmt.setInt(2,id);
		pstmt.setInt(1, price);
		
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
		try{
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
	
	
	