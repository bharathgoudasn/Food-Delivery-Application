package com.food.dao;

import java.util.List;

import com.food.model.Orders;

public interface OdersDAO {

	 public int insert(Orders o);
	   public List<Orders> fetchAll();
	   public  Orders fetchOne(int id);
	   public int update(int id, String status);
	   public int delete(int idd);

}
