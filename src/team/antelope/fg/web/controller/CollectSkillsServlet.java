package team.antelope.fg.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.antelope.fg.service.SkillCollectService;
import team.antelope.fg.service.impl.SkillCollectServiceImpl;

/**
 * 收藏或取消收藏
 * @author 廖翔
 *
 */
@WebServlet(name="CollectSkillsServlet", urlPatterns="/CollectSkillsServlet")
public class CollectSkillsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String user_id = req.getParameter("userid");
		String skill_id = req.getParameter("skillid");
		
		SkillCollectService skillCollectService = new SkillCollectServiceImpl();
//		if ((user_id!=null||!user_id.equals(""))||(skill_id!=null||!skill_id.equals(""))) {
			//判断是否已经收藏过，是则执行取消收藏事件，否则添加收藏。
		System.out.println("userID"+user_id+"——————skillID"+skill_id);
			boolean flag = skillCollectService.judgeSkillExist(user_id, skill_id);
			System.out.println(flag);
			
			if (flag) {
				skillCollectService.cancelCollection(user_id, skill_id);
				System.out.println("取消");
			}else {
				skillCollectService.addCollection(user_id, skill_id);
				System.out.println("收藏");
			}
//		}
		
		
	}
}
