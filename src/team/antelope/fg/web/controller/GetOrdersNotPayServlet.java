package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.entity.Orders;
import team.antelope.fg.service.IOrdersService;
import team.antelope.fg.service.impl.OrdersServiceImpl;

/**
 * 根据当前登录用户获取Ta的所有的未支付订单
 * @author 廖翔
 *
 */
@WebServlet(name="GetOrdersNotPayServlet", urlPatterns="/GetOrdersNotPayServlet")
public class GetOrdersNotPayServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String uid = req.getParameter("uid");
		long id = 0l;
		if(uid != null && !"".equals(uid)){
			id = Long.parseLong(uid);
		}
		IOrdersService iOrdersService = new OrdersServiceImpl();
		List<Orders> orders = iOrdersService.getNotPayOrders(id);
		System.out.println("——————"+orders);
		PrintWriter printWriter = resp.getWriter();
		returnJson(orders, printWriter);
	}
	
	private void returnJson(List<Orders> orders, PrintWriter printWriter){
		Gson gson = new Gson();
		String json = gson.toJson(orders);
		System.out.println("json"+json);
		printWriter.write(json);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
