package team.antelope.fg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team.antelope.fg.biz.ICommentService;
import team.antelope.fg.biz.ISkillService;
import team.antelope.fg.constant.DBConst;
import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.CommentVo;
import team.antelope.fg.util.Log4jUtil;

/**
 * 技能控制器
 * @author 华文财
 * @time:2018年5月13日 下午7:40:45
 * @Description:TODO
 */
@Controller
@RequestMapping("/skill")
public class SkillController {
	//注入业务逻辑对象
	@Autowired
	private ISkillService skillService;
	@Autowired
	private ICommentService commentService;
	
	@RequestMapping(value="/toSkillInfo", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toSkillInfo (@RequestParam(name="id") Long id, @RequestParam(name="latitude") Double latitude, 
			@RequestParam(name="longitude") Double longitude) throws Exception{
		
		//调用service方法获取NeedExpand
		Log4jUtil.info("id: " + id + " latitude: "+ latitude +" longitude:" + longitude);
		SkillExpand skillExpand = skillService.getSkillInfoById(id, latitude, longitude);
		
		//查询所属的评论
		CommentVo commentVo = new CommentVo();
		commentVo.setCommentExpand(new CommentExpand());
		List<CommentExpand> commentExpands = commentService.getCommentsByTopicId(id, DBConst.COMMENT_TOPICTYPE_Skill, commentVo);
		//建立模型数据
		ModelAndView modelAndView = new ModelAndView();
		//给modelAndView设置数据
		modelAndView.addObject("skillExpand", skillExpand);
		modelAndView.addObject("commentExpands", commentExpands);
		//设置视图
		modelAndView.setViewName("commons/skillInfo");
		return modelAndView;
	}
	
}
