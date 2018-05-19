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
 * É¾³ý¶©µ¥
 * @author ÁÎÏè
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
		super.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String orderId = req.getParameter("id");
		
		System.out.println("¶©µ¥ºÅ£º"+orderId);
		
		IOrdersService iOrdersService = new OrdersServiceImpl();
		iOrdersService.deleteOrder(orderId);
	}
}
