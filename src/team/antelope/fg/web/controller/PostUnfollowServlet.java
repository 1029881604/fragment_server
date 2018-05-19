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
import team.antelope.fg.dao.impl.PersonDaoImpl;
import team.antelope.fg.dao.impl.UFDaoImpl;
import team.antelope.fg.entity.Attention;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.service.impl.UserServiceImpl;

/*
 * YY
 * 取消关注
 * */
@WebServlet(name = "PostUnfollowServlet", urlPatterns = { "/PostUnfollowServlet" })
public class PostUnfollowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostUnfollowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		Long person_id = Long.parseLong(request.getParameter("person_id"));
		Long attention_id=Long.parseLong(request.getParameter("attention_id"));
		System.out.println("-----------"+person_id+"-----------");
		System.out.println("-----------"+attention_id+"-----------");
        Attention attention = new UFDaoImpl().queryById(person_id, attention_id);
        new UFDaoImpl().delete(attention);
        System.out.println("删除成功");
		
	}

}
