package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.service.IUserService;
import team.antelope.fg.service.impl.UserServiceImpl;
@WebServlet(name="flag_GetUserPersonServlet", urlPatterns="/GetUserPersonServlet")
public class GetUserPersonServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String sid = req.getParameter("id");
		long id = 0l;
		if(sid != null && !"".equals(sid)){
			id = Long.parseLong(sid);
		}
		System.out.println("id:"+id);
		IUserService userService = new UserServiceImpl();
		Person p = userService.getUserPerson(id);
		PrintWriter writer = resp.getWriter();
//		session.setAttribute("friends", friends);
//		response.sendRedirect("friendList.jsp"); 
		returnJson(p, writer);
	}
	private void returnJson(Person person, PrintWriter writer){
		Gson gson = new Gson();
		String json = gson.toJson(person);
		System.out.println(json);
		writer.write(json);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
