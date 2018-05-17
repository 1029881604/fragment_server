package team.antelope.fg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team.antelope.fg.biz.ICommentService;
import team.antelope.fg.biz.INeedService;
import team.antelope.fg.constant.DBConst;
import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.vo.CommentVo;
import team.antelope.fg.util.Log4jUtil;

/**
 * 需求Handler
 * @author 华文财
 * @time:2018年5月13日 下午7:40:19
 * @Description:TODO
 */
@Controller
@RequestMapping("/need")
public class NeedController {
	
	@Autowired
	private INeedService needService;
	@Autowired
	private ICommentService commentService;
	
	
	@RequestMapping(value="/toNeedInfo", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView toNeedInfo(@RequestParam(name="id") Long id, @RequestParam(name="latitude") Double latitude, 
			@RequestParam(name="longitude") Double longitude) throws Exception{
		
		//调用service方法获取NeedExpand
		Log4jUtil.info("id: " + id + " latitude: "+ latitude +" longitude:" + longitude);
		NeedExpand needExpand = needService.getNeedInfoById(id, latitude, longitude);
		
		//查询所属的评论
		CommentVo commentVo = new CommentVo();
		commentVo.setCommentExpand(new CommentExpand());
		List<CommentExpand> commentExpands = commentService.getCommentsByTopicId(id, DBConst.COMMENT_TOPICTYPE_NEED, commentVo);
		//建立模型数据
		ModelAndView modelAndView = new ModelAndView();
		//给modelAndView设置数据
		modelAndView.addObject("needExpand", needExpand);
		modelAndView.addObject("commentExpands", commentExpands);
		commentExpands.forEach(s->{
			System.out.println(s);
		});
		//设置视图
		modelAndView.setViewName("commons/needInfo");
		return modelAndView;
	}
	
}
