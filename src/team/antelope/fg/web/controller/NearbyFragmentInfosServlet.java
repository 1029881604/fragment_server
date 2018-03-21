package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.constant.SkillAndNeedConst;
import team.antelope.fg.entity.NearbyModularInfo;
import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.SkillPreInfo;
import team.antelope.fg.service.impl.NearbyServiceImpl;
import team.antelope.fg.service.impl.UserServiceImpl;

public class NearbyFragmentInfosServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
//		UserServiceImpl userServiceImpl = new UserServiceImpl();
//		List<NeedPreInfo> needsProInfo = userServiceImpl.getNeedProInfoList();  ��ȡ���е���������
		String type = req.getParameter("type");
		System.out.println("type:"+type);
		// ��֤����
		//.....
		NearbyServiceImpl service = new NearbyServiceImpl();
		
		NearbyModularInfo modularInfo = service.getNearbyModularInfo(type);
		System.out.println(modularInfo);
		PrintWriter writer = resp.getWriter();
//		session.setAttribute("friends", friends);
//		response.sendRedirect("friendList.jsp"); 
		returnJson(modularInfo, writer);
	}
	private void returnJson(NearbyModularInfo nearbyModularInfo, PrintWriter writer){
		Gson gson = new Gson();
		String json = gson.toJson(nearbyModularInfo);
		writer.write(json);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		doGet(req, resp);
	}
	
}
