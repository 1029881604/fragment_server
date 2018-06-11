package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.entity.Orders;
import team.antelope.fg.service.IOrdersService;
import team.antelope.fg.service.impl.OrdersServiceImpl;

@WebServlet(name="GetOrderDetailsServlet", urlPatterns="/GetOrderDetailsServlet")
public class GetOrderDetailsServlet extends HttpServlet {

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
		
		String orderId = req.getParameter("orderId");
		
		long id = 0l;
		if(orderId != null && !"".equals(orderId)){
			id = Long.parseLong(orderId);
		}
		
		IOrdersService iOrdersService = new OrdersServiceImpl();
		Orders orders = iOrdersService.getOrderDetails(id);
		
		System.out.println("Orders！！！！！！"+orders);
		PrintWriter printWriter = resp.getWriter();
		returnJson(orders, printWriter);
	}
	
	private void returnJson(Orders orders, PrintWriter printWriter){
		Gson gson = new Gson();
		String json = gson.toJson(orders);
		System.out.println("json"+json);
		printWriter.write(json);
	}

}
