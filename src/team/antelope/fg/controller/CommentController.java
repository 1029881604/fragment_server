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
	
	@RequestMapping(value="/addNeedCommentAsync", method={RequestMethod.POST, RequestMethod.GET})
	public void addNeedCommentAsync(CommentExpand commentExpand, HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//从session中获取person，将其传入service
		HttpSession session = req.getSession();
		resp.setContentType("application/json; charset=utf-8"); 
		Person user = (Person) session.getAttribute(SessionConst.SESSION_LOGIN_USER);
		if(user == null){
			resp.getWriter().write("{\"message\":\"请重新登入\"}");
			return;
		}
		
		System.out.println("sessionUser:" +user.toString());
		
		//指定业务类型
		Short topicType = DBConst.COMMENT_TOPICTYPE_NEED;
		//调用业务类进行业务处理
		CommentVo commentVo = new CommentVo();
		commentVo.setCommentExpand(commentExpand);
		//业务处理后返回带有主键的comment
		CommentExpand addedCommentExpand = commentService.saveNeedCommentsAsync(topicType, user, commentVo);
		System.out.println(addedCommentExpand);
		resp.getWriter().write(GsonUtil.GsonString(addedCommentExpand));
		
	}
}
