package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

import com.food.DBconnection.DBconnection;
import com.food.dao.OrderHistoryDAO;
import com.food.model.OrderHistory;

public class OrderHistoryDAOimpl implements OrderHistoryDAO

{

	private static Connection con;
	ArrayList<OrderHistory> list=new ArrayList<>();
	private static final String INSERT="insert into OrderHistory(orderhistoryid,orderid,userid,totalamount,status) values(?,?,?,?,?)";
	private static final String FETCHALL="select * from OrderHistory";
	private static final String FETCHONE="Select * from OrderHistory where orderhistoryid=?";
	private static final String UPDATE="update OrderHistory set email=? where orderhistoryid=?";
	private static final String DELETE="delete from OrderHistory where orderhistoryid=?";
	static
	{
		con=DBconnection.connect();
	}

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	
	@Override
	public int insert(OrderHistory o) {
		try
		{
		pstmt=con.prepareStatement(INSERT);
		pstmt.setInt(1, o.getOrderhistoryid());
		pstmt.setInt(2,o.getOrderid());
		pstmt.setInt(3, o.getUserid());
		pstmt.setInt(4, o.getTotalamount());
		pstmt.setString(5, o.getStatus());

		return pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<OrderHistory> fetchAll() {
		try
		{
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(FETCHALL);
		return orderhist(resultSet);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<OrderHistory> orderhist(ResultSet rl){
		try
		{
			while(rl.next())
			{
				list.add(
						new OrderHistory(
								rl.getInt("orderhistoryid"),
								rl.getInt("orderid"),
								rl.getInt("useridid"),
								rl.getInt("totalamount"),
								rl.getString("status")
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
	public OrderHistory fetchone(int id) {
		try
		{
		pstmt=con.prepareStatement(FETCHONE);
		pstmt.setInt(1,id);
		resultSet=pstmt.executeQuery();
		list=orderhist(resultSet);
		
		return list.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int update(int id, String status) {
		try
		{
		pstmt=con.prepareStatement(UPDATE);
		pstmt.setInt(2,id);
		pstmt.setString(1, status);

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