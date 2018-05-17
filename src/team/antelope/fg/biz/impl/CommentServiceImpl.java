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
import team.antelope.fg.util.Log4jUtil;
/**
 * ����ʵ��ҵ�������ʵ����
 * @author ���Ĳ�
 * @time:2018��5��16�� ����10:12:34
 * @Description:TODO
 */
public class CommentServiceImpl implements ICommentService {

	@Autowired  //ע���Զ���customCommentMapper
	private CustomCommentMapper customCommentMapper;
	
	
	@Override
	public List<CommentExpand> getCommentsByTopicId(Long topicId, Short topicType, CommentVo commentVo)  throws Exception {
		CommentExpand commentExpand = commentVo.getCommentExpand();
		commentExpand.setTopicId(topicId);
		commentExpand.setTopicType(topicType);
		return customCommentMapper.queryCommentsByTopicId(commentVo);
	}
	
	@Override
	public CommentExpand saveNeedCommentsAsync(Short topicType, Person user, CommentVo commentVo) throws Exception{
		//ָ��ҵ������--��������
		CommentExpand commentExpand = commentVo.getCommentExpand();
		commentExpand.setTopicType(topicType);
		//ָ��ҵ����� user���uid, headimg, userName
		commentExpand.setUserId(user.getId());
		commentExpand.setUserImg(user.getHeadimg());
		commentExpand.setNickname(user.getName());
		
		commentExpand.setCommentStatus((short)1);
		commentExpand.setCreateTime(new Date());  //����ʱ��
		//������ֶ�Ҫôָ��Ĭ�ϵģ�Ҫô�ͷ�װ����,��ҵ�����ָ��һ��
		commentExpand.setCommentStatus(DBConst.COMMENT_STATUS_PUBLISH);
		commentExpand.setIsHot(false);
		commentExpand.setIsReply(false);
		commentExpand.setIsTop(false);
		commentExpand.setLikeNum(0);
		//commentExpand.setTopicId(topicId);�Ѿ�����
		commentExpand.setReplyNum(0);
		
		Log4jUtil.error("customExpandid1:" + commentExpand.getId());
		customCommentMapper.insertAndReturnKey(commentVo);
		Log4jUtil.error("customExpandid2:" + commentExpand.getId()+",userimg"+commentExpand.getUserImg());
		return commentExpand;
	}

}
