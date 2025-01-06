package com.food.dao;

import java.util.ArrayList;

import com.food.model.OrderHistory;

public interface OrderHistoryDAO {

	public int insert(OrderHistory oh);
	public ArrayList<OrderHistory> fetchAll();
	public OrderHistory fetchone(int id);
	public int update(int id,String status);
	public int delete(int d);

}
