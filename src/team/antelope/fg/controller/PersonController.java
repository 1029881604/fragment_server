package team.antelope.fg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.antelope.fg.biz.IPersonService;
import team.antelope.fg.constant.SessionConst;
import team.antelope.fg.pojo.Person;
import team.antelope.fg.util.Log4jUtil;

/**
 * 会员后端控制器
 * @author 华文财
 * @time:2018年5月13日 下午7:39:11
 * @Description:TODO
 */
@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private IPersonService personService;
	
	@RequestMapping(value="/userLogin", method={RequestMethod.GET, RequestMethod.POST})
	public void userLogin(HttpServletRequest req, Person person){
		
		Person user = personService.loginByName(person.getName(), person.getPassword());
		System.out.println("loginUser:" +user.toString());
		HttpSession session = req.getSession();
		session.setAttribute(SessionConst.SESSION_LOGIN_USER, user);
	}
}
