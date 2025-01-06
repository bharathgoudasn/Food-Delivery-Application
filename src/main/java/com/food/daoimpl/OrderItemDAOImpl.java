package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

import com.food.DBconnection.DBconnection;
import com.food.dao.OrderItemDAO;
import com.food.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO
{


	private static Connection con;
	ArrayList<OrderItem> list=new ArrayList<>();
	private static final String INSERT="insert into OrderItem(orderid,menuid,quantity,itemtotal) values(?,?,?,?)";
	private static final String FETCHALL="select * from OrderItem";
	private static final String FETCHONE="Select * from OrderItem where orderitemid=?";
	private static final String UPDATE="update OrderItem set quantity=? where orderitemid=?";
	private static final String DELETE="delete from OrderItem where orderitemid=?";
	static
	{
		con=DBconnection.connect();
	}

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	
	
	@Override
	public int insert(OrderItem o) {
		try
		{
		pstmt=con.prepareStatement(INSERT);
		pstmt.setInt(1,o.getOrderid());
		pstmt.setInt(2, o.getMenuid());
		pstmt.setInt(3, o.getQuantity());
		pstmt.setFloat(4, o.getItemtotal());

		return pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<OrderItem> fetchAll() {
		try
		{
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(FETCHALL);
		return orderItems(resultSet);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<OrderItem> orderItems(ResultSet rl){
		try
		{
			while(rl.next())
			{
				list.add(
						new OrderItem(
								rl.getInt("orderitemid"),
								rl.getInt("orderid"),
								rl.getInt("menuid"),
								rl.getInt("quantity"),
								rl.getFloat("itemtotal")
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
	public OrderItem fetchOne(int id) {
		try
		{
		pstmt=con.prepareStatement(FETCHONE);
		pstmt.setInt(1,id);
		resultSet=pstmt.executeQuery();
		list=orderItems(resultSet);
		
		return list.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int update(int id, int quantity) {
		try
		{
		pstmt=con.prepareStatement(UPDATE);
		pstmt.setInt(2,id);
		pstmt.setInt(1, quantity);

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