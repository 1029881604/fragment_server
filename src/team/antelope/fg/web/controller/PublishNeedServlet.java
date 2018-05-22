package team.antelope.fg.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.service.impl.PublishServiceImpl;

/**
 * @author uniquelry
 * @Date 2018年5月19日 下午11:49:41
 * @Description 发布需求的Servlet
 */
@WebServlet("/PublishNeedServlet")
public class PublishNeedServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String json=req.getParameter("json");
		if(json!=null) {
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			PublishNeed need=gson.fromJson(json, new TypeToken<PublishNeed>() {}.getType());
			System.out.println("need:"+need.toString());
			int state=new PublishServiceImpl().publishNeed(need);
			if(state==1) {
				resp.getWriter().print("success");
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
