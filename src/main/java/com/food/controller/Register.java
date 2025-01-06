package com.food.controller;

import java.io.IOException;

import com.food.daoimpl.UserDAOimp;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet 
{

  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
	  String password=req.getParameter("password");
	  if(password.equals(req.getParameter("cpassword"))) 
	  {
		  String username=Myencrypt.encrypt(req.getParameter("username"));
		  String email=Myencrypt.encrypt(req.getParameter("email"));
		  String address=Myencrypt.encrypt(req.getParameter("address"));
		  User u=new User(username,Myencrypt.encrypt(password),email,address);
		  UserDAOimp udao = new UserDAOimp();
		
			  
		  resp.sendRedirect("front.jsp");
	  }
	  else {
		  resp.getWriter().println("password Mismatch");
		  
	  }
}
}
