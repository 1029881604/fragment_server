package team.antelope.fg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team.antelope.fg.biz.IAttentionService;
import team.antelope.fg.biz.IPersonService;
import team.antelope.fg.constant.RequestScopeConst;
import team.antelope.fg.constant.SessionConst;
import team.antelope.fg.pojo.AttentionKey;
import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.expand.PersonInfoExpand;

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
	
	
	@RequestMapping(value="/userLogin", method={RequestMethod.GET, RequestMethod.POST})
	public void userLogin(HttpServletRequest req, Person person){
//		Person user = personService.loginByName(person.getName(), person.getPassword());
//		System.out.println("loginUser:" +user.toString());
//		HttpSession session = req.getSession();
//		session.setAttribute(SessionConst.SESSION_LOGIN_USER, user);
	}
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
	
}
