package team.antelope.fg.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.antelope.fg.service.IOrdersService;
import team.antelope.fg.service.impl.OrdersServiceImpl;

/**
 * ��Ӷ���
 * @author ����
 *
 */
@WebServlet(name="AddOrderServlet", urlPatterns="/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
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
		
		String uid = req.getParameter("uid");
		String uid_s = req.getParameter("uid_s");
		String skillid = req.getParameter("skillid");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String img = req.getParameter("img");
		String skilltype = req.getParameter("skilltype");
		String ispay = req.getParameter("ispay");
		String isdelete = req.getParameter("isdelete");
		String iscomment = req.getParameter("iscomment");
		
		IOrdersService iOrdersService = new OrdersServiceImpl();
		iOrdersService.addOrder(uid, uid_s, skillid, title, content, img, skilltype, ispay, isdelete, iscomment);
	
		System.out.println(uid);
		System.out.println(uid_s);
		System.out.println(ispay);
	}
}
