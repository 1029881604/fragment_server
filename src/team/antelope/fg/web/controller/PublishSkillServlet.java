package team.antelope.fg.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.service.impl.PublishServiceImpl;

/**
 * @author uniquelry
 * @Date 2018��5��19�� ����11:52:54
 * @Description �������ܵ�Servlet
 */
@WebServlet("/PublishSkillServlet")
public class PublishSkillServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String json=request.getParameter("json");
		if(json!=null) {
			PublishSkill skill=new Gson().fromJson(json, new TypeToken<PublishSkill>() {}.getType());
			System.out.println("skill:"+skill.toString());
			int state=new PublishServiceImpl().publishSkill(skill);
			if(state==1) {
				response.getWriter().print("success");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
