package team.antelope.fg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team.antelope.fg.biz.IAttentionService;
import team.antelope.fg.biz.ICommentService;
import team.antelope.fg.biz.INeedService;
import team.antelope.fg.biz.IPersonService;
import team.antelope.fg.biz.ISkillService;
import team.antelope.fg.constant.DBConst;
import team.antelope.fg.constant.RequestScopeConst;
import team.antelope.fg.constant.SessionConst;
import team.antelope.fg.pojo.AttentionKey;
import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.expand.PersonInfoExpand;
import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.CommentVo;
import team.antelope.fg.pojo.vo.NeedVo;
import team.antelope.fg.pojo.vo.PersonInfoVo;
import team.antelope.fg.pojo.vo.SkillVo;

/**
 * 会员后端控制器
 * @author 华文财
 * @time:2018年5月13日 下午7:39:11
 * @Description:TODO
 */
@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired	//注入用户服务
	private IPersonService personService;
	
	@Autowired	//注入关注服务
	private IAttentionService attentionService;
	@Autowired //注入评论业务服务
	private ICommentService commentService;
	@Autowired //注入需求业务服务
	private INeedService needService;
	@Autowired //注入需求业务服务
	private ISkillService skillService;
	
	
	
	
	@RequestMapping(value="/userLogin", method={RequestMethod.GET, RequestMethod.POST})
	public void userLogin(HttpServletRequest req, Person person){
		Person user = personService.loginByName(person.getName(), person.getPassword());
		System.out.println("loginUser:" +user.toString());
		HttpSession session = req.getSession();
		session.setAttribute(SessionConst.SESSION_LOGIN_USER, user);
	}
	/**
	 * 关注用户
	 * @param req
	 * @param needFollowPerson
	 * @return
	 * @throws Exception 
	 * ModelAndView
	 */
	@RequestMapping(value="/followPerson", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView followPerson(HttpServletRequest req, PersonInfoExpand needFollowPerson) throws Exception{
		
		HttpSession session = req.getSession();
		//查看数据库有没有这个人？，这里为了方便，不做验证
		Person user = (Person) session.getAttribute(SessionConst.SESSION_LOGIN_USER);

		ModelAndView modelAndView = new ModelAndView();
		if(user == null){
			session.setAttribute(SessionConst.ERROR_MESSAGE, "登入超时， 请重新登入...");
			modelAndView.setViewName("commons/error");
			return modelAndView;
		}
	
		AttentionKey attention = new AttentionKey();
		attention.setAttentionuserid(needFollowPerson.getId());
		attention.setUid(user.getId());
		//检查是否已经关注
		AttentionKey checkAttention = attentionService.checkFollowStatus(attention);
		//如果已经关注了， 则返回信息为已经关注
		String followStatus = "关注失败 QAQ";
		if(checkAttention != null){
			followStatus = "您已经关注了ta...";
		} else{//如果没有， 则关注
			followStatus = "关注成功! >>-<<";
			attentionService.followPerson(attention);
		}
		
		modelAndView.addObject(RequestScopeConst.FOLLOW_STATUS, followStatus);
		modelAndView.setViewName("commons/followResult");
		return modelAndView;
	}
	
	@RequestMapping(value="/getPersonDetail", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getPersonDetail(HttpServletRequest req, PersonInfoExpand personInfoExpand) throws Exception{
		
		//关注列表，发布过的技能列表， 发布过的需求列表，评论列表
		//关注列表
		PersonInfoVo personInfoVo = new PersonInfoVo();
		personInfoVo.setPersonInfoExpand(personInfoExpand);
		List<PersonInfoExpand> followedUsers = personService.getFollowedUsers(personInfoVo);
		//评论列表
		Long topicId = personInfoExpand.getId();
		Short topicType = DBConst.COMMENT_TOPICTYPE_USER;
		CommentVo commentVo = new CommentVo();
		commentVo.setCommentExpand(new CommentExpand());
		List<CommentExpand> commentExpandList = commentService.getCommentsByTopicId(topicId, topicType, commentVo);
		//需求列表
		NeedVo needVo = new NeedVo();
		needVo.setNeedExpand(new NeedExpand());
		List<NeedExpand> needInfos = needService.getNeedInfosByPerson(personInfoExpand.getId(), needVo);
		//技能列表
		SkillVo skillVo = new SkillVo();
		skillVo.setSkillExpand(new SkillExpand());
		List<SkillExpand> skillInfos = skillService.getSkillInfosByPerson(personInfoExpand.getId(), skillVo);
		
		ModelAndView modelAndView = new ModelAndView();
		//设置request域的数据
		modelAndView.addObject(RequestScopeConst.REQUEST_USER, personInfoExpand);
		modelAndView.addObject(RequestScopeConst.FOLLOWEDUSERS, followedUsers);
		modelAndView.addObject(RequestScopeConst.COMMENTEXPANDLIST, commentExpandList);
		modelAndView.addObject(RequestScopeConst.USER_ALL_NEEDINFO, needInfos);
		modelAndView.addObject(RequestScopeConst.USER_ALL_SKILLINFO, skillInfos);
		modelAndView.setViewName("nearby/personDetail");
		return modelAndView;
	}
	
	
	
	
	
}
