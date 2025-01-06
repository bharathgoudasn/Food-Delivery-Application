package com.food.controller;

import java.io.IOException;
import java.util.List;

import com.food.dao.RestaurantDAO;
import com.food.daoimpl.MenuDAOImpl;
import com.food.daoimpl.RestaurantDAOImpl;
import com.food.model.Menu;
import com.food.model.Restuarant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetMenu")
public class GetMenu extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
			int r_id=Integer.parseInt(req.getParameter("restaurantId"));
			HttpSession session=req.getSession();
			session.setAttribute("restaurantId", r_id);
			
			MenuDAOImpl rdao=new MenuDAOImpl();
			List<Menu> menulist = rdao.fetchMenuByRestaurant(r_id);
			// add menulist and restaurantid to request
			req.setAttribute("menulist", menulist);
			req.setAttribute("restaurantId", r_id);
			
			// add restaurant object to session
			RestaurantDAO res=new RestaurantDAOImpl();
			Restuarant restaurant=res.fetchOne(r_id);
			session.setAttribute("restaurant", restaurant);
			
			
			RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
			rd.forward(req, resp);
			
	}
	}

