package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.service.ISkillService;
import team.antelope.fg.service.impl.SkillServiceImpl;

/**
 * 
 * @author Kyrene
 *
 */
@WebServlet(name="flag_GetSkillByPersonServlet", urlPatterns="/GetSkillByPersonServlet")
public class GetSkillByPersonServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String sid = req.getParameter("id");
		long id = 0l;
		if(sid != null && !"".equals(sid)){
			id = Long.parseLong(sid);
		}
		System.out.println("byPerson");
		
		ISkillService iSkillService = new SkillServiceImpl();
		List<PublishSkill> skills = iSkillService.getSkillsByPerson(id);
		System.out.println("！！！！！！"+skills);
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
