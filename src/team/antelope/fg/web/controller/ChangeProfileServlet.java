package team.antelope.fg.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.antelope.fg.service.impl.ChangeProfileServiceImpl;

public class ChangeProfileServlet extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		   String after_name= request.getParameter("after_name");
		     String after_sex= request.getParameter("after_sex");
		     String after_age= request.getParameter("after_age");
		     String after_email= request.getParameter("after_email");
		     String user_id =request.getParameter("user_id");
		     ChangeProfileServiceImpl change = new ChangeProfileServiceImpl();
		     change.ChangeProfileService(user_id, after_name, after_email, after_age, after_sex);
		  System.out.println(after_name);
		  System.out.println(after_sex);
		  System.out.println(after_age);
		  System.out.println(after_email);
		  System.out.println(user_id);
		
		
	}

}
