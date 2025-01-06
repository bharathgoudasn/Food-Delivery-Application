package com.food.dao;

import java.util.List;

import com.food.model.OrderItem;

public interface OrderItemDAO {

	public int insert(OrderItem o);
	   public List<OrderItem> fetchAll();
	   public OrderItem fetchOne(int id);
	   public int update(int id, int quantity);
	   public int delete(int d);

}
