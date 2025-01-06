package com.food.controller;

import java.io.IOException;
import java.util.List;

import com.food.dao.RestaurantDAO;
import com.food.daoimpl.RestaurantDAOImpl;
import com.food.model.Restuarant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetRestuarants")
public class GetRestuarants extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Cookie[] cookies=req.getCookies();
		HttpSession session = req.getSession();
		if(cookies[0].getValue()!=null) {
			RestaurantDAO rdao=new RestaurantDAOImpl();
			List<Restuarant> restuarantlist = rdao.fetchAll();
			session.setAttribute("restuarantlist", restuarantlist);
			resp.sendRedirect("home.jsp");
		}
		else {
			resp.sendRedirect("login.jsp");
		}
	}
}
