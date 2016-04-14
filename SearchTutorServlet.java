package com.varadhisoft.hometuitions.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import com.varadhisoft.hometuitions.beans.TutorBean;
import com.varadhisoft.hometuitions.dao.impl.TutorDAO;
import com.varadhisoft.hometuitions.service.TutorServiceInterface;
import com.varadhisoft.hometuitions.service.impl.TutorService;

public class SearchTutorServlet extends HttpServlet 

{

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		doProcess(req,resp);		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		doProcess(req,resp);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
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
		
		/*// Form data capturing 	
		String name = req.getParameter("name");
		// creating a Bean instance
		TutorBean tutor = new TutorBean();
				
		//Populating the bean
		tutor.setName(name);*/
		
		// call the Service layer
		TutorServiceInterface tutorService = new TutorService();
		List<TutorBean> tutorsList = tutorService.searchTutor(tutor);
		String page ="failure.jsp";
		if(tutorsList!=null)
		 {
			 if("India".equals(req.getParameter("keyIndia")))
			 {
				 page = "updatetutorresults.jsp";
				 System.out.println("This is inside the if clause");
			 }
			 else
			 {
				/* page = "updatetutorresults.jsp";*/
			   page = "tutorresults.jsp";
			 }
	       System.out.println(page);
		// share the data in the scope 
			 req.setAttribute("tutorsList", tutorsList);
			 
		  System.out.println(tutorsList.isEmpty());
		 }
		// Transfer the control to appropriate jsp
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, resp);
		
	}
}
