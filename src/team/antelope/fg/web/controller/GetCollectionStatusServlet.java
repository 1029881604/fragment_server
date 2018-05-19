package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.service.SkillCollectService;
import team.antelope.fg.service.impl.SkillCollectServiceImpl;

/**
 * 获取收藏状态
 * @author 廖翔
 *
 */
@WebServlet(name="GetCollectionStatusServlet", urlPatterns="/GetCollectionStatusServlet")
public class GetCollectionStatusServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String user_id = req.getParameter("userid");
		String skill_id = req.getParameter("skillid");
		
		String status = "";
		SkillCollectService skillCollectService = new SkillCollectServiceImpl();
		boolean flag = skillCollectService.judgeSkillExist(user_id, skill_id);
		
		if (flag) {
			status = "已收藏";
		}else {
			status = "收藏";
		}
		
		PrintWriter printWriter = resp.getWriter();
		returnJson(status, printWriter);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	private void returnJson(String s, PrintWriter printWriter){
		Gson gson = new Gson();
		String json = gson.toJson(s);
		System.out.println("json_____"+json);
		printWriter.write(json);
	}
}
