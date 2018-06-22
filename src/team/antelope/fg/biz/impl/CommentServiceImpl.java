package team.antelope.fg.biz.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.biz.ICommentService;
import team.antelope.fg.constant.DBConst;
import team.antelope.fg.mapper.custom.CustomCommentMapper;
import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.vo.CommentVo;
import team.antelope.fg.util.DateUtil;
import team.antelope.fg.util.Log4jUtil;
/**
 * 评论实体业务服务类实现类
 * @author 华文财
 * @time:2018年5月16日 上午10:12:34
 * @Description:TODO
 */
public class CommentServiceImpl implements ICommentService {

	@Autowired  //注入自定义customCommentMapper
	private CustomCommentMapper customCommentMapper;
	
	
	@Override
	public List<CommentExpand> getCommentsByTopicId(Long topicId, Short topicType, CommentVo commentVo)  throws Exception {
		CommentExpand commentExpand = commentVo.getCommentExpand();
		commentExpand.setTopicId(topicId);
		commentExpand.setTopicType(topicType);
		List<CommentExpand> commentExpandList = customCommentMapper.queryCommentsByTopicId(commentVo);
		System.out.println("--------------list--:"+commentExpandList);
		commentExpandList.forEach(comment ->{
			Date date = comment.getCreateTime();
			if(date == null){
				date = new Date();
			}
			System.out.println("--------------dd--:"+date);
			//业务指定str
			String dateStr = DateUtil.formatDataTime3(date);
			comment.setCreateTimeStr(dateStr);
		});
		return commentExpandList;
	}

	/**
	 * 暂时异步添加需求和技能和用户的业务是一样的
	 */
	@Override
	public CommentExpand saveCommentsAsync(Short topicType, Person user, CommentVo commentVo) throws Exception{
		//指定业务类型--主题类型
		CommentExpand commentExpand = commentVo.getCommentExpand();
		commentExpand.setTopicType(topicType);
		//指定业务对象， user相关uid, headimg, userName
		commentExpand.setUserId(user.getId());
		commentExpand.setUserImg(user.getHeadimg());
		commentExpand.setNickname(user.getName());
		
		commentExpand.setCommentStatus((short)1);
		Date date = new Date();
		commentExpand.setCreateTime(date);  //创建时间
		//其余的字段要么指定默认的，要么就封装好了,在业务层在指定一遍
		commentExpand.setCommentStatus(DBConst.COMMENT_STATUS_PUBLISH);
		commentExpand.setIsHot(false);
		commentExpand.setIsReply(false);
		commentExpand.setIsTop(false);
		commentExpand.setLikeNum(0);
		//commentExpand.setTopicId(topicId);已经有了
		commentExpand.setReplyNum(0);
		
		//业务指定str
		String dateStr = DateUtil.formatDataTime3(date);
		commentExpand.setCreateTimeStr(dateStr);
		customCommentMapper.insertAndReturnKey(commentVo);
		return commentExpand;
	}

}
