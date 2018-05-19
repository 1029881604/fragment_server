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
import team.antelope.fg.biz.IPersonService;
import team.antelope.fg.constant.DBConst;
import team.antelope.fg.constant.RequestScopeConst;
import team.antelope.fg.constant.SessionConst;
import team.antelope.fg.pojo.AttentionKey;
import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.expand.PersonInfoExpand;
import team.antelope.fg.pojo.vo.CommentVo;
import team.antelope.fg.pojo.vo.PersonInfoVo;

/**
 * ��Ա��˿�����
 * @author ���Ĳ�
 * @time:2018��5��13�� ����7:39:11
 * @Description:TODO
 */
@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired	//ע���û�����
	private IPersonService personService;
	
	@Autowired	//ע���ע����
	private IAttentionService attentionService;
	@Autowired //ע������ҵ�����
	private ICommentService commentService;
	
	
	
	
	@RequestMapping(value="/userLogin", method={RequestMethod.GET, RequestMethod.POST})
	public void userLogin(HttpServletRequest req, Person person){
		Person user = personService.loginByName(person.getName(), person.getPassword());
		System.out.println("loginUser:" +user.toString());
		HttpSession session = req.getSession();
		session.setAttribute(SessionConst.SESSION_LOGIN_USER, user);
	}
	/**
	 * ��ע�û�
	 * @param req
	 * @param needFollowPerson
	 * @return
	 * @throws Exception 
	 * ModelAndView
	 */
	@RequestMapping(value="/followPerson", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView followPerson(HttpServletRequest req, PersonInfoExpand needFollowPerson) throws Exception{
		
		HttpSession session = req.getSession();
		//�鿴���ݿ���û������ˣ�������Ϊ�˷��㣬������֤
		Person user = (Person) session.getAttribute(SessionConst.SESSION_LOGIN_USER);

		ModelAndView modelAndView = new ModelAndView();
		if(user == null){
			session.setAttribute(SessionConst.ERROR_MESSAGE, "���볬ʱ�� �����µ���...");
			modelAndView.setViewName("commons/error");
			return modelAndView;
		}
	
		AttentionKey attention = new AttentionKey();
		attention.setAttentionuserid(needFollowPerson.getId());
		attention.setUid(user.getId());
		//����Ƿ��Ѿ���ע
		AttentionKey checkAttention = attentionService.checkFollowStatus(attention);
		//����Ѿ���ע�ˣ� �򷵻���ϢΪ�Ѿ���ע
		String followStatus = "��עʧ�� QAQ";
		if(checkAttention != null){
			followStatus = "���Ѿ���ע��ta...";
		} else{//���û�У� ���ע
			followStatus = "��ע�ɹ�! >>-<<";
			attentionService.followPerson(attention);
		}
		
		modelAndView.addObject(RequestScopeConst.FOLLOW_STATUS, followStatus);
		modelAndView.setViewName("commons/followResult");
		return modelAndView;
	}
	
	@RequestMapping(value="/getPersonDetail", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getPersonDetail(HttpServletRequest req, PersonInfoExpand personInfoExpand) throws Exception{
		
		//��ע�б��������ļ����б� �������������б������б�
		//��ע�б�
		PersonInfoVo personInfoVo = new PersonInfoVo();
		personInfoVo.setPersonInfoExpand(personInfoExpand);
		List<PersonInfoExpand> followedUsers = personService.getFollowedUsers(personInfoVo);
		//�����б�
		Long topicId = personInfoExpand.getId();
		Short topicType = DBConst.COMMENT_TOPICTYPE_USER;
		CommentVo commentVo = new CommentVo();
		commentVo.setCommentExpand(new CommentExpand());
		List<CommentExpand> commentExpandList = commentService.getCommentsByTopicId(topicId, topicType, commentVo);
		//�����б�
		ModelAndView modelAndView = new ModelAndView();
		//����request�������
		modelAndView.addObject(RequestScopeConst.REQUEST_USER, personInfoExpand);
		modelAndView.addObject(RequestScopeConst.FOLLOWEDUSERS, followedUsers);
		modelAndView.addObject(RequestScopeConst.COMMENTEXPANDLIST, commentExpandList);
		modelAndView.setViewName("nearby/personDetail");
		return modelAndView;
	}
	
	
	
	
	
}
