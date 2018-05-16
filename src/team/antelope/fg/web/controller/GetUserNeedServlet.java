package team.antelope.fg.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import team.antelope.fg.dao.IPersonDao;
import team.antelope.fg.dao.IPublishNeedDao;
import team.antelope.fg.dao.impl.PersonDaoImpl;
import team.antelope.fg.dao.impl.PersonInfoDaoImpl;
import team.antelope.fg.dao.impl.PublishNeedDaoImpl;
import team.antelope.fg.dao.impl.UserDaoImpl;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.entity.PersonNeed;
import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.service.IUserService;
import team.antelope.fg.service.impl.UserServiceImpl;

/*
 * create by YY
 * 
 * */
@WebServlet(name="GetUserNeedServlet", urlPatterns={"/GetUserNeedServlet"})  
public class GetUserNeedServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserNeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	
	String sid = request.getParameter("id");
	System.out.println("ÓÃ»§Id"+sid);
	Long id= 0L;
	if(sid != null && !"".equals(sid)){
		id = Long.parseLong(sid);
	}
List<PublishNeed> publishNeeds = new ArrayList<>();
publishNeeds =  new PublishNeedDaoImpl().queryByuid(id);
   
//	if(person == null){
//		response.sendRedirect("login.jsp");
//		return;
//	}
	PrintWriter writer = response.getWriter();
//	session.setAttribute("friends", friends);
//	response.sendRedirect("friendList.jsp"); 
	returnJson(publishNeeds, writer);
	}

	
	private void returnJson(List<PublishNeed> publishNeeds, PrintWriter writer){
		Gson gson = new Gson();
		String json1 = gson.toJson(publishNeeds);
		System.out.println("GetUserNeedServlet"+json1);
		writer.write(json1);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
