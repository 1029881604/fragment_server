package team.antelope.fg.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.biz.ICommentService;
import team.antelope.fg.mapper.custom.CustomCommentMapper;
import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.vo.CommentVo;
/**
 * ����ʵ��ҵ�������ʵ����
 * @author ���Ĳ�
 * @time:2018��5��16�� ����10:12:34
 * @Description:TODO
 */
public class CommentServiceImpl implements ICommentService {

	@Autowired  //ע��commentMapper
	private CustomCommentMapper commentMapper;
	
	@Override
	public List<CommentExpand> getCommentsByTopicId(Long topicId, Short topicType, CommentVo commentVo) {
		CommentExpand commentExpand = commentVo.getCommentExpand();
		commentExpand.setTopicId(topicId);
		commentExpand.setTopicType(topicType);
		return commentMapper.queryCommentsByTopicId(commentVo);
	}

}
