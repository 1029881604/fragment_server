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

import team.antelope.fg.dao.impl.CollectionSkillDaoImpl;
import team.antelope.fg.dao.impl.PublishNeedDaoImpl;
import team.antelope.fg.dao.impl.PublishSkillDaoImpl;
import team.antelope.fg.entity.CollectionSkill;
import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.entity.PublishSkill;
/*
 * create by YY
 * 
 * */
@WebServlet(name="GetMeCollectionServlet", urlPatterns={"/GetMeCollectionServlet"})  
public class GetMeCollectionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMeCollectionServlet() {
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
List<CollectionSkill> collectionSkills = new CollectionSkillDaoImpl().queryCollectsByUserId(id);
List<PublishSkill> publishSkills = new ArrayList<>();
for(int i = 0;i<collectionSkills.size();i++) {
	CollectionSkill collectionSkill= new CollectionSkill();
	PublishSkill publishSkill = new PublishSkill();
	collectionSkill=collectionSkills.get(i);
	publishSkill= new PublishSkillDaoImpl().queryById(collectionSkill.getSkill_id());
  publishSkills.add(publishSkill);

}


   
//	if(person == null){
//		response.sendRedirect("login.jsp");
//		return;
//	}
	PrintWriter writer = response.getWriter();
//	session.setAttribute("friends", friends);
//	response.sendRedirect("friendList.jsp"); 
	returnJson(publishSkills, writer);
	}

	
	private void returnJson(List<PublishSkill> publishSkills, PrintWriter writer){
		Gson gson = new Gson();
		String json1 = gson.toJson(publishSkills);
		System.out.println("GetMeCollectionServlet"+json1);
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
