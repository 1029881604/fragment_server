package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.entity.User;
import team.antelope.fg.service.impl.UserServiceImpl;

/**
 * 
 * @author 华文财
 * @time:2018年5月10日 下午7:25:06
 * @Description:TODO
 */
public class UserFindFriendsJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFindFriendsJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("person");
		if(person == null){
			response.sendRedirect("login.jsp");
			return;
		}
		List<PersonInfo> friends = new UserServiceImpl().findFriend(person);
		PrintWriter writer = response.getWriter();
//		session.setAttribute("friends", friends);
//		response.sendRedirect("friendList.jsp"); 
		returnFriendJson(friends, writer);
	}

	
	private void returnFriendJson(List<PersonInfo> friends, PrintWriter writer){
		Gson gson = new Gson();
		String json = gson.toJson(friends);
		writer.write(json);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
