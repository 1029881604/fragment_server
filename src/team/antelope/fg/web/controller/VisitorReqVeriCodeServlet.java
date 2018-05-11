package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.antelope.fg.service.impl.VisitorServiceSSLImpl;

/**
 * 
 * @author 华文财
 * @time:2018年5月10日 下午7:24:16
 * @Description:TODO
 */
public class VisitorReqVeriCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 5566081424996134093L;
	private static final String NEED_EMAIL = "请输入邮箱";
	private static final String SEND_SUCCESS = "请去邮箱查看验证码";

	/**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorReqVeriCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String reqEmail = request.getParameter("email");
		PrintWriter writer = response.getWriter();
		if(reqEmail == null || "".equals(reqEmail)){
			writer.write(NEED_EMAIL);
			return;
		} 
//		String veriCode = new VisitorServiceImpl().returnVeriCode(reqEmail);
		String veriCode = new VisitorServiceSSLImpl().returnVeriCode(reqEmail);
		HttpSession session = request.getSession();
		System.out.println("reqId:" + request.getRequestedSessionId());
		System.out.println("respId:" + session.getId());
		session.setAttribute("veriCode", veriCode);
		writer.write(SEND_SUCCESS);
		System.out.println(session.getId());
		System.out.println(veriCode);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
