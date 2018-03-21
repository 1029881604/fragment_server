package team.antelope.fg.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.antelope.fg.entity.User;
import team.antelope.fg.exception.UserExistException;
import team.antelope.fg.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserRegisterServlet
 */
//@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NAME_EXISTS = "用户名已存在";
	private static final String NEED_NAME = "请输入用户名";
	private static final String NEED_PASSWORD = "请输入密码";
	private static final String REGISTER_SUCCESS = "注册成功";   
	private static final String NEED_VERICODE = "请输入验证码";   
	private static final String ERROR_VERICODE = "验证码错误";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String veriCode = request.getParameter("veriCode");
		HttpSession session = request.getSession();
		if(name == null|| "".equals(name.trim()) ){
			response.getWriter().write(NEED_NAME);
			return;
		} else if( password == null||"".equals(password.trim()) ){
			response.getWriter().write(NEED_PASSWORD);
			return;
		} else if(veriCode == null || "".equals(veriCode.trim()) ){
			response.getWriter().write(NEED_VERICODE);
			return;
		} 
		String sendVeriCode = (String) session.getAttribute("veriCode");
		if(!veriCode.equals(sendVeriCode)){
			System.out.println(session.getId());
			response.getWriter().write(ERROR_VERICODE);
			return;
		}
		User user = new User(name, password, email);
		try {
			new UserServiceImpl().register(user);
		} catch (UserExistException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().write(NAME_EXISTS);
			return;
		}
		response.getWriter().write(REGISTER_SUCCESS);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
