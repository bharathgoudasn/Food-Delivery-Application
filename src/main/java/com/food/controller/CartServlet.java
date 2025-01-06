package com.food.controller;

import java.io.IOException;

import com.food.dao.MenuDAO;
import com.food.daoimpl.MenuDAOImpl;
import com.food.model.CartItem;
import com.food.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Cart cart=(Cart)session.getAttribute("Cart");
		if(cart==null) {
			cart=new Cart();
			session.setAttribute("Cart", cart);
		}
		
		
		String action=req.getParameter("action");
		int itemId=Integer.parseInt(req.getParameter("menuid"));
		
		MenuDAO menuDAO=null;
		try {
			menuDAO=new MenuDAOImpl();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(action.equals("add")) {
			Menu menuItem=menuDAO.fetchOne(itemId);
			if(menuItem!=null) {
			int quantity=1;
			CartItem cartItem = new CartItem(menuItem.getMenuid(),menuItem.getRestaurantid(),menuItem.getName(),quantity,menuItem.getPrice());
			cart.addItem(cartItem);
			}
		}
		else if(action.equals("update"))
		{	
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			cart.updateItem(itemId, quantity);
		}
		else if(action.equals("remove"))
		{
			cart.removeItem(itemId);
		}
		session.setAttribute("Cart", cart);
		resp.sendRedirect("Cart.jsp");
		
		
	}

}
