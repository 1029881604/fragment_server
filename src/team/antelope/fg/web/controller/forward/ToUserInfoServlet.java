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
import team.antelope.fg.util.Log4jUtil;

/**
 * 
 * @author ���Ĳ�
 * @time:2018��4��10�� ����3:14:53
 * @Description:TODO�� ��ת���û�������Ϣҳ��
 */
@WebServlet(name="flag_toUserInfoServlet", urlPatterns="/forward/ToUserInfoServlet")
public class ToUserInfoServlet extends HttpServlet {
		private static INearbyService nearbyService = new NearbyServiceImpl();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html; charset=utf-8");
			String sid = req.getParameter("id");
			Long id = Long.valueOf(sid);
			if(id <0){
				return;
			}
			PersonInfo personInfo = nearbyService.getPersonInfo(id);
			HttpSession session = req.getSession();
			System.out.println("3_reqgetsessid"+req.getRequestedSessionId());
			System.out.println("3_sessionid:" + session.getId());
			session.setAttribute(SessionConst.NEARBY_PERSONINFO, personInfo);
			req.getRequestDispatcher("/jsp/nearby/personInfo.jsp").forward(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
		
}
