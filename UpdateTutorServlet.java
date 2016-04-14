package com.varadhisoft.hometuitions.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.varadhisoft.hometuitions.beans.TutorBean;
import com.varadhisoft.hometuitions.service.TutorServiceInterface;
import com.varadhisoft.hometuitions.service.impl.TutorService;

public class UpdateTutorServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		doProcess(req, resp);
	}
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// Form data capturing 	
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String qualification = req.getParameter("qualification");
		String syllabus = req.getParameter("syllabus");
		String contactNumber = req.getParameter("contactNumber");
		String area = req.getParameter("area");
		
		// creating a Bean instance
		TutorBean tutor = new TutorBean();
		
		//Populating the bean
		tutor.setName(name);
		tutor.setSex(sex);
		tutor.setQualification(qualification);
		tutor.setSyllabus(syllabus);
		tutor.setContactNumber(contactNumber);
		tutor.setArea(area);
		
		String page = "failure.jsp";
		boolean flag = false;
		TutorServiceInterface tutorservice = new TutorService();
		flag = tutorservice.updateTutor(tutor);
		
	    if(flag)
	    {
	    	page="registrationsuccess.jsp";
	    }
	    else
	    {
	    	page = "failure.jsp";
	    }
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, resp);
	}
	

}
