package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.service.ISkillService;
import team.antelope.fg.service.impl.SkillServiceImpl;

/**
 * CreateBy:Lx
 * Time:2018/4/3
 * 
 * */

public class GetCustomizedSkillServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String skillType = req.getParameter("skilltype");
		System.out.println("skillType:"+skillType);
		
		ISkillService skillServiceImpl = new SkillServiceImpl();
		List<PublishSkill> skills = skillServiceImpl.getOnlineSkillsByType(skillType);
		System.out.println("111111111111111");
		PrintWriter printWriter = resp.getWriter();
		returnJson(skills, printWriter);
	}
	
	private void returnJson(List<PublishSkill> publishSkills, PrintWriter printWriter){
		Gson gson = new Gson();
		String json = gson.toJson(publishSkills);
		System.out.println("json"+json);
		printWriter.write(json);
	}

}
