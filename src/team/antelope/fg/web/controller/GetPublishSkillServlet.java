package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.entity.SkillPreInfo;
import team.antelope.fg.service.impl.UserServiceImpl;

public class GetPublishSkillServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String sid = req.getParameter("id");
		long id = 0l;
		if(sid != null && !"".equals(sid)){
			id = Long.parseLong(sid);
		}
		System.out.println("id:"+id);
		PublishSkill skill = new UserServiceImpl().getSkill(id);
		System.out.println("skill:"+skill);
		PrintWriter writer = resp.getWriter();
//		session.setAttribute("friends", friends);
//		response.sendRedirect("friendList.jsp"); 
		returnJson(skill, writer);
	}
	private void returnJson(PublishSkill skill, PrintWriter writer){
		Gson gson = new Gson();
		String json = gson.toJson(skill);
		System.out.println(json);
		writer.write(json);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doGet(req, resp);
	}
	
}
