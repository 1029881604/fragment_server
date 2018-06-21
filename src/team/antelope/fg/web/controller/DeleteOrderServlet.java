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
 * ɾ������
 * @author ����
 *
 */
@WebServlet(name="DeleteOrderServlet", urlPatterns="/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String orderId = req.getParameter("id");
		
		IOrdersService iOrdersService = new OrdersServiceImpl();
		System.out.println("ɾ�������ţ�"+orderId);
		iOrdersService.deleteOrder(orderId);
		System.out.println("ִ��ɾ�����");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
