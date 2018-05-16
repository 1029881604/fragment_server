package team.antelope.fg.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.biz.ICommentService;
import team.antelope.fg.mapper.custom.CustomCommentMapper;
import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.vo.CommentVo;
/**
 * 评论实体业务服务类实现类
 * @author 华文财
 * @time:2018年5月16日 上午10:12:34
 * @Description:TODO
 */
public class CommentServiceImpl implements ICommentService {

	@Autowired  //注入commentMapper
	private CustomCommentMapper commentMapper;
	
	@Override
	public List<CommentExpand> getCommentsByTopicId(Long topicId, Short topicType, CommentVo commentVo) {
		CommentExpand commentExpand = commentVo.getCommentExpand();
		commentExpand.setTopicId(topicId);
		commentExpand.setTopicType(topicType);
		return commentMapper.queryCommentsByTopicId(commentVo);
	}

}
