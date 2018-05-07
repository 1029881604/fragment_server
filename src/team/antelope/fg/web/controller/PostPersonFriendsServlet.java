package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import team.antelope.fg.dao.IPersonDao;
import team.antelope.fg.dao.IPersonInfoDao;
import team.antelope.fg.dao.impl.PersonDaoImpl;
import team.antelope.fg.dao.impl.PersonInfoDaoImpl;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.service.impl.UserServiceImpl;

@WebServlet(name="PostPersonFriendsServlet", urlPatterns={"/PostPersonFriendsServlet"})  
public class PostPersonFriendsServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostPersonFriendsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	private void returnFriendJson(List<PersonInfo> friends, PrintWriter writer){
		Gson gson = new Gson();
		String json = gson.toJson(friends);
		System.out.println("GetPersonFriendsServlet"+json);
		writer.write(json);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		Long person_id = Long.parseLong(request.getParameter("person_id"));
		IPersonDao personDao =new PersonDaoImpl();
		
		Person person = personDao.queryById(person_id);
	   
	   
//		if(person == null){
//			response.sendRedirect("login.jsp");
//			return;
//		}
		List<PersonInfo> friends = new UserServiceImpl().findFriend(person);
		PrintWriter writer = response.getWriter();
//		session.setAttribute("friends", friends);
//		response.sendRedirect("friendList.jsp"); 
		returnFriendJson(friends, writer);
	}

}
