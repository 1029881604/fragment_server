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

import team.antelope.fg.entity.PersonNeed;
import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.service.IPublishService;
import team.antelope.fg.service.impl.PublishServiceImpl;

/**
 * @author uniquelry
 * @Date 2018��4��8�� ����6:36:05
 * @Description �������ջ�ȡ�����б������
 */
@WebServlet(name="GetAllPersonNeedServlet", urlPatterns={"/GetAllPersonNeedServlet"})  
public class GetAllPersonNeedServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		IPublishService publishService = new PublishServiceImpl();
		List<PersonNeed> personNeeds = publishService.getAllPersonNeed();
		PrintWriter writer = resp.getWriter();
		returnJson(personNeeds, writer);
	}
	private void returnJson(List<PersonNeed> needs, PrintWriter writer){
		Gson gson = new Gson();
		String json = gson.toJson(needs);
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
