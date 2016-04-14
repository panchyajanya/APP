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

public class DeleteTutorServlet extends HttpServlet 
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
				/*String sex = request.getParameter("sex");
				String qualification = request.getParameter("qualification");
				String syllabus = request.getParameter("syllabus");
				String contactNumber = request.getParameter("contactNumber");
				String area = request.getParameter("area");*/
				
				// creating a Bean instance
				TutorBean tutor = new TutorBean();
				
				//Populating the bean
				tutor.setName(name);
				/*tutor.setSex(sex);
				tutor.setQualification(qualification);
				tutor.setSyllabus(syllabus);
				tutor.setContactNumber(contactNumber);
				tutor.setArea(area);*/
				
				// call the Service layer
				TutorServiceInterface tutorService = new TutorService();
				boolean flag = tutorService.deleteTutor(tutor);	
				
				String fileName = "registrationfailure.jsp";
				if(flag){
					fileName = "registrationsuccess.jsp";
				}
				
				// Transfer the control to appropriate jsp
				RequestDispatcher rd = req.getRequestDispatcher(fileName);
				rd.forward(req, resp);
		

	}

}
