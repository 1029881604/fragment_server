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
 * 
 * @author ���Ĳ�
 * @time:2018��5��10�� ����7:24:52
 * @Description:TODO
 */
//@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String LOGIN_SUCCESS="����ɹ�";
	public static final String NEED_NAME="�������˺�";
	public static final String NEED_PWD="����������";
	public static final String ERROR_INPUT="�˺Ż��������";
       
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
		response.setContentType("application/json; charset=utf-8"); 
		Gson gson = new Gson();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account == null || "".equals(account.trim())){
			System.out.println(NEED_NAME);
			String json = gson.toJson(new String[]{NEED_NAME, null});
			response.getWriter().write(json);
			return;
		} else if(password == null || "".equals(password.trim())){
			System.out.println(NEED_PWD);
			String json = gson.toJson(new String[]{NEED_PWD, null});
			response.getWriter().write(json);
			return;
		}
		System.out.println("post ��get ִ�У�");
		System.out.println(account+"---"+password);
		Person person = null;
		try {
			person = new UserServiceImpl().login(account, password);
			System.out.println(person.toString());
		} catch (UserNameNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("�û�������");
			String json = gson.toJson(new String[]{ERROR_INPUT, null});
			response.getWriter().write(json);
			return;
		} catch (UserPasswordErrorException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("�������");
			String json = gson.toJson(new String[]{ERROR_INPUT, null});
			System.out.println("json:"+json);
			response.getWriter().write(json);
			return;
		}
		HttpSession session = request.getSession();
		
		session.setAttribute("person", person);
		String json = gson.toJson(new String[]{LOGIN_SUCCESS, String.valueOf(person.getId())});
		System.out.println("����ɹ�");
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
