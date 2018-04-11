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

import team.antelope.fg.entity.PersonSkill;
import team.antelope.fg.service.IPublishService;
import team.antelope.fg.service.impl.PublishServiceImpl;


/**
 * @author uniquelry
 * @Date 2018��4��9�� ����1:45:22
 * @Description �������ջ�ȡ�����б������
 */
@WebServlet(name="GetAllPersonSkillServlet", urlPatterns={"/GetAllPersonSkillServlet"})
public class GetAllPersonSkillServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		IPublishService publishService = new PublishServiceImpl();
		List<PersonSkill> personSkills = publishService.getAllPersonSkill();
		PrintWriter writer = resp.getWriter();
		returnJson(personSkills, writer);
	}
	private void returnJson(List<PersonSkill> skills, PrintWriter writer){
		Gson gson = new Gson();
		String json = gson.toJson(skills);
		System.out.println("GetAllPersonSkillServlet"+json);
		writer.write(json);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		doGet(req, resp);
	}
}
