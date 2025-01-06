package com.food.dao;

import java.util.List;

import com.food.model.Restuarant;

public interface RestaurantDAO {
	   public int insert(Restuarant restaurant);
	   public List<Restuarant> fetchAll();
	   public  Restuarant fetchOne(int id);
	   public int update(int id, float rating);
	   public int delete(int id);
	}