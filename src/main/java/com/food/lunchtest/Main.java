package com.food.lunchtest;

import com.food.daoimpl.OrderItemDAOImpl;
import com.food.model.OrderItem;


public class Main {

	public static void main(String[] args) 
	{
		//User u=new User("james","1234","jame@gmail.com","BLGr");
		 // UserDAOimp udao = new UserDAOimp();
//		  if(udao.insert(u)==1)
//		  {
//			  System.out.println("inserted success");
//		  }
//		  else {
//			  System.out.println("inserted failure");
//		  }
//		  
		OrderItem item=new OrderItem(3,1,3,56);
	         OrderItemDAOImpl dao= new	OrderItemDAOImpl();
		int v=dao.insert(item);
		System.out.println(v);
	}
}
