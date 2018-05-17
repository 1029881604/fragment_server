package team.antelope.fg.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import team.antelope.fg.biz.IPersonService;
import team.antelope.fg.biz.impl.PersonServiceImpl;
import team.antelope.fg.constant.SessionConst;
import team.antelope.fg.entity.Person;
import team.antelope.fg.exception.UserNameNotFoundException;
import team.antelope.fg.exception.UserPasswordErrorException;
import team.antelope.fg.service.impl.UserServiceImpl;

/**
 * 
 * @author 华文财
 * @time:2018年5月10日 下午7:24:52
 * @Description:TODO
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String LOGIN_SUCCESS="登入成功";
	public static final String NEED_NAME="请输入账号";
	public static final String NEED_PWD="请输入密码";
	public static final String ERROR_INPUT="账号或密码错误";
	private IPersonService personService;
	
	@Override
	public void init() throws ServletException {
		WebApplicationContext  ctx= WebApplicationContextUtils.getWebApplicationContext(getServletContext());  
		personService = (IPersonService) ctx.getBean("personService");
	}
	
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
		System.out.println("post 和get 执行！");
		System.out.println(account+"---"+password);
		Person person = null;
		try {
			person = new UserServiceImpl().login(account, password);
			System.out.println(person.toString());
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
			System.out.println("json:"+json);
			response.getWriter().write(json);
			return;
		}
		HttpSession session = request.getSession();
		
		session.setAttribute(SessionConst.SESSION_LOGIN_PERSON, person);
		
		String json = gson.toJson(new String[]{LOGIN_SUCCESS, String.valueOf(person.getId())});

	    team.antelope.fg.pojo.Person user = personService.loginByName(person.getName(), person.getPassword());
		session.setAttribute(SessionConst.SESSION_LOGIN_USER, user);
		System.out.println("登入成功");
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
