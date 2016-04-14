package com.varadhisoft.hometuitions.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.varadhisoft.hometuitions.beans.StudentBean;
import com.varadhisoft.hometuitions.service.StudentServiceInterface;
import com.varadhisoft.hometuitions.service.impl.StudentService;

public class SearchStudentServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doProcess(request,response);		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doProcess(request,response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		// Form data capturing 	
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String qualification = request.getParameter("qualification");
		String syllabus = request.getParameter("syllabus");
		String contactNumber = request.getParameter("contactNumber");
		String area = request.getParameter("area");
		
		// creating a Bean instance
		StudentBean student = new StudentBean();
		
		//Populating the bean
		student.setName(name);
		student.setSex(sex);
		student.setQualification(qualification);
		student.setSyllabus(syllabus);
		student.setContactNumber(contactNumber);
		student.setArea(area);
		
		// call the Service layer
		StudentServiceInterface studentService = new StudentService();
		List<StudentBean> studentList = studentService.searchStudent(student);
	
		// share the data in the scope 
		request.setAttribute("studentList", studentList);
		
		// Transfer the control to appropriate jsp
		RequestDispatcher rd = request.getRequestDispatcher("studentresults.jsp");
		rd.forward(request, response);
		
	}

}
