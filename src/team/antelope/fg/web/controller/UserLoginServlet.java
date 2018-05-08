package team.antelope.fg.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import team.antelope.fg.entity.Person;
import team.antelope.fg.exception.UserNameNotFoundException;
import team.antelope.fg.exception.UserPasswordErrorException;
import team.antelope.fg.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
//@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String LOGIN_SUCCESS="登入成功";
	public static final String NEED_NAME="请输入账号";
	public static final String NEED_PWD="请输入密码";
	public static final String ERROR_INPUT="账号或密码错误";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account == null || "".equals(account.trim())){
			response.getWriter().write(NEED_NAME);
			return;
		} else if(password == null || "".equals(password.trim())){
			response.getWriter().write(NEED_PWD);
			return;
		}
		
		Gson gson = new Gson();
		System.out.println(account+"---"+password);
		Person person = null;
		try {
			person = new UserServiceImpl().login(account, password);
			System.out.println(person.toString());
			System.out.println("reqgetsessid"+request.getRequestedSessionId());
			System.out.println("sessionId"+ request.getSession().getId());
		} catch (UserNameNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("用户名错误");
			String json = gson.toJson(new String[]{ERROR_INPUT, null});
			response.getWriter().write(json);
			return;
		} catch (UserPasswordErrorException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("密码错误");
			String json = gson.toJson(new String[]{ERROR_INPUT, null});
			response.getWriter().write(json);
			return;
		}
		HttpSession session = request.getSession();
		
		session.setAttribute("person", person);
		String json = gson.toJson(new String[]{LOGIN_SUCCESS, String.valueOf(person.getId())});
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
