package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.service.impl.UserServiceImpl;
import team.antelope.fg.util.Log4jUtil;

public class GetPublishNeedServlet extends HttpServlet {
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
		PublishNeed need = new UserServiceImpl().getNeed(id);
		PrintWriter writer = resp.getWriter();
		returnJson(need, writer);
	}
	private void returnJson(PublishNeed need, PrintWriter writer){
		Gson gson = new Gson();
		String json = gson.toJson(need);
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
