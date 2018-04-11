package team.antelope.fg.web.controller.forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.antelope.fg.constant.SessionConst;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.service.INearbyService;
import team.antelope.fg.service.impl.NearbyServiceImpl;

/**
 * 
 * @author 华文财
 * @time:2018年4月10日 下午3:14:53
 * @Description:TODO， 跳转到用户个人信息页面
 */
@WebServlet(name="flag_toUserInfoServlet", urlPatterns="/ToUserInfoServlet")
public class ToUserInfoServlet extends HttpServlet {
		private static INearbyService nearbyService = new NearbyServiceImpl();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html; charset=utf-8");
			String sid = req.getParameter("id");
			Long id = Long.valueOf(sid);
			System.out.println("ididididididid"+id);
			if(id <0){
				return;
			}
			PersonInfo personInfo = nearbyService.getPersonInfo(id);
			HttpSession session = req.getSession();
			session.setAttribute(SessionConst.NEARBY_PERSONINFO, personInfo);
			req.getRequestDispatcher("/jsp/nearby/personInfo.jsp").forward(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
		
}
