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
import team.antelope.fg.service.ISearchSkillsService;
import team.antelope.fg.service.impl.SearchSkillServiceImpl;

/***
 * 
 * @author Kyrene
 *
 */
@WebServlet(name="flag_SearchSkillsServlet", urlPatterns="/SearchSkillsServlet")
public class SearchSkillsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String keyword = req.getParameter("keyword");
		System.out.println("------Keyword------"+keyword);
		
		ISearchSkillsService iSearchSkillsService = new SearchSkillServiceImpl();
		List<PublishSkill> skills = iSearchSkillsService.getSearchResult(keyword);
		
		PrintWriter printWriter = resp.getWriter();
		returnJson(skills, printWriter);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	private void returnJson(List<PublishSkill> publishSkills, PrintWriter printWriter){
		Gson gson = new Gson();
		String json = gson.toJson(publishSkills);
		System.out.println("json"+json);
		printWriter.write(json);
	}

}
