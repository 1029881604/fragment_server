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
 * �ղػ�ȡ���ղ�
 * @author ����
 *
 */
@WebServlet(name="k_CollectSkillsServlet", urlPatterns="/CollectSkillsServlet")
public class CollectSkillsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String user_id = req.getParameter("userid");
		String skill_id = req.getParameter("skillid");
		
		SkillCollectService skillCollectService = new SkillCollectServiceImpl();
		//�ж��Ƿ��Ѿ��ղع�������ִ��ȡ���ղ��¼�����������ղء�
		boolean flag = skillCollectService.judgeSkillExist(user_id, skill_id);
		System.out.println(flag);
		
		if (flag) {
			skillCollectService.cancelCollection(user_id, skill_id);
		}else {
			skillCollectService.addCollection(user_id, skill_id);
		}
		
	}
}
