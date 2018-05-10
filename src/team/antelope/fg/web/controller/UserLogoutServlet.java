package team.antelope.fg.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import team.antelope.fg.entity.Person;
import team.antelope.fg.util.Log4jUtil;
@WebServlet(urlPatterns={"/user/UserLogoutServlet"})
public class UserLogoutServlet  extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8"); 
		HttpSession session = request.getSession();
		Person p = (Person) session.getAttribute("person");//在session中存储，一旦清空session，则不能在session.invalidate();之后访问
		if(p!=null){
			Log4jUtil.info(p.getName() +" logout");
		}
		session.invalidate();
		response.getWriter().write("\"logout ok\"");
	}
}
