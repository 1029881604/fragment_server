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
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.service.impl.UserServiceImpl;
/*
 *  YY
 * �ҷ�˿
 * */
@WebServlet(name = "PostFindFansServlet", urlPatterns = { "/PostFindFansServlet" })
public class PostFindFansServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostFindFansServlet() {
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

	private void returnFriendJson(List<PersonInfo> listFans, PrintWriter writer) {
		Gson gson = new Gson();
		String json = gson.toJson(listFans);
		System.out.println("GetPersonFriendsServlet" + json);
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
		System.out.println("*******personid**************"+person_id);
		Person person = personDao.queryById(person_id);
		List<PersonInfo> listFans = new ArrayList<>();
		List<PersonInfo> fans=new ArrayList<>();
		List<PersonInfo> friends = new UFDaoImpl().findAllPerson(person);
		if (friends!=null&&friends.size()>0) {
			for(int i=0;i<friends.size();i++) {
				PersonInfo personinfo1=friends.get(i);
				System.out.println("��"+i+"��friends*******"+personinfo1.getId());
				Person fan = personDao.queryById(personinfo1.getId());
//				System.out.println("id:"+fan.getId()+"������"+fan.getName());
			 fans= new UFDaoImpl().findFollow(fan); 
					if(fans!=null&&fans.size()>0) {
						for(int j=0;j<fans.size();j++)
						{
							PersonInfo personinfo2=new PersonInfo();
							personinfo2 = fans.get(j);
							System.out.println("��"+j+"����*******"+personinfo2.getId());
							if (personinfo2.getId().equals(person_id)) {
								listFans.add(personinfo1);
								System.out.println("�ӽ�����");
							}
					}
					}else 
						continue;
	        }
		}
	

	
		PrintWriter writer = response.getWriter();
//		session.setAttribute("friends", friends);
//		response.sendRedirect("friendList.jsp"); 
		returnFriendJson(listFans, writer);
	}

}
