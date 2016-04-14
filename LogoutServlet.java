package com.varadhisoft.hometuitions.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet
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
		HttpSession session = req.getSession();
		session.invalidate();
		RequestDispatcher rd = req.getRequestDispatcher("logout.jsp");
		rd.forward(req, res);
	}
}
