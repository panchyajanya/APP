package com.varadhisoft.hometuitions.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.varadhisoft.hometuitions.service.LoginServiceInterface;
import com.varadhisoft.hometuitions.service.impl.LoginService;

public class LoginServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doProcess(req,res);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doProcess(req,res);
	}
	private void doProcess(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		LoginServiceInterface loginService = new LoginService();
		boolean flag = loginService.validateUser(username, password);
		String filename ="failure.jsp";
		if(flag){
			req.setAttribute("un",username);
			filename="homepage.jsp";
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(10*60);
			session.setAttribute("username", username);			
		}
		RequestDispatcher rd= req.getRequestDispatcher(filename);
			rd.forward(req,res);
		}

	}


	


