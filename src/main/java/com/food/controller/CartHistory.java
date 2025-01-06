package com.food.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.food.daoimpl.OrdersDAOImpl;
import com.food.model.Orders;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartHistory")
public class CartHistory extends HttpServlet {

	private OrdersDAOImpl dao;
	private ArrayList<Orders> orders;
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("User");
		dao=new OrdersDAOImpl();
		orders=dao.fetchbyUserId(user.getUserId());
		session.setAttribute("OrderHistory",orders);
		resp.sendRedirect("OrderHistory.jsp");
	}



}
