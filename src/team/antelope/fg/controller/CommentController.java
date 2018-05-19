package team.antelope.fg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.antelope.fg.biz.ICommentService;
import team.antelope.fg.constant.DBConst;
import team.antelope.fg.constant.SessionConst;
import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.vo.CommentVo;
import team.antelope.fg.util.common.GsonUtil;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@RequestMapping(value="/addPersonCommentAsync", method={RequestMethod.POST, RequestMethod.GET})
	public void addPersonCommentAsync(CommentExpand commentExpand, HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//��session�л�ȡperson�����䴫��service
		HttpSession session = req.getSession();
		resp.setContentType("application/json; charset=utf-8"); 
		Person user = (Person) session.getAttribute(SessionConst.SESSION_LOGIN_USER);
		if(user == null){
			resp.getWriter().write("{\"message\":\"�����µ���\"}");
			return;
		}
		
		//ָ��ҵ������
		Short topicType = DBConst.COMMENT_TOPICTYPE_USER;
		//����ҵ�������ҵ����
		CommentVo commentVo = new CommentVo();
		commentVo.setCommentExpand(commentExpand);
		//ҵ����󷵻ش���������comment
		CommentExpand addedCommentExpand = commentService.saveCommentsAsync(topicType, user, commentVo);
		System.out.println("---------------addedCommentExpand:"+addedCommentExpand);
		
		System.out.println(addedCommentExpand);
		resp.getWriter().write(GsonUtil.GsonString(addedCommentExpand));
		
	}
	@RequestMapping(value="/addNeedCommentAsync", method={RequestMethod.POST, RequestMethod.GET})
	public void addNeedCommentAsync(CommentExpand commentExpand, HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//��session�л�ȡperson�����䴫��service
		HttpSession session = req.getSession();
		resp.setContentType("application/json; charset=utf-8"); 
		Person user = (Person) session.getAttribute(SessionConst.SESSION_LOGIN_USER);
		if(user == null){
			resp.getWriter().write("{\"message\":\"�����µ���\"}");
			return;
		}
		
		//ָ��ҵ������
		Short topicType = DBConst.COMMENT_TOPICTYPE_NEED;
		//����ҵ�������ҵ����
		CommentVo commentVo = new CommentVo();
		commentVo.setCommentExpand(commentExpand);
		//ҵ����󷵻ش���������comment
		CommentExpand addedCommentExpand = commentService.saveCommentsAsync(topicType, user, commentVo);
		System.out.println(addedCommentExpand);
		resp.getWriter().write(GsonUtil.GsonString(addedCommentExpand));
		
	}
	
	@RequestMapping(value="/addSkillCommentAsync", method={RequestMethod.POST, RequestMethod.GET})
	public void addSkillCommentAsync(CommentExpand commentExpand, HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//��session�л�ȡperson�����䴫��service
		HttpSession session = req.getSession();
		resp.setContentType("application/json; charset=utf-8"); 
		Person user = (Person) session.getAttribute(SessionConst.SESSION_LOGIN_USER);
		if(user == null){
			resp.getWriter().write("{\"message\":\"�����µ���\"}");
			return;
		}
		
		//ָ��ҵ������
		Short topicType = DBConst.COMMENT_TOPICTYPE_Skill;
		//����ҵ�������ҵ����
		CommentVo commentVo = new CommentVo();
		commentVo.setCommentExpand(commentExpand);
		//ҵ����󷵻ش���������comment
		CommentExpand addedCommentExpand = commentService.saveCommentsAsync(topicType, user, commentVo);
		System.out.println(addedCommentExpand);
		resp.getWriter().write(GsonUtil.GsonString(addedCommentExpand));
		
	}
}
