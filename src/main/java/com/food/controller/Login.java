package com.food.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.food.DBconnection.DBconnection;
import com.food.daoimpl.UserDAOimp;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet 
{

	private static Connection con;
	private PreparedStatement pstmt;
	private String checkemail="select * from user where email=?";
	private ResultSet res;
	
	static
	{
		con=DBconnection.connect();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email=Myencrypt.encrypt(req.getParameter("email"));
		String  password=Myencrypt.encrypt(req.getParameter("password"));
		HttpSession session=req.getSession();
		//resp.getWriter().println("hi bharath");
		try
		{
			pstmt=con.prepareStatement(checkemail);
			pstmt.setString(1,email);
			res=pstmt.executeQuery();
			 
			if(res.next()) {
				if(password.equals(res.getString("password")))
				{
					UserDAOimp udao=new UserDAOimp();
					User u=udao.fetch(email);
					session.setAttribute("User", u);
					req.getRequestDispatcher("GetRestuarants").forward(req, resp);
				}
				else {
					String perror="Incorrect password. Please try again.t";
					req.setAttribute("error",perror );
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}
			else {
				String perror="Email not recognized. Please try again or sign up.";
				req.setAttribute("error",perror );
				req.getRequestDispatcher("login.jsp").forward(req, resp);

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
