package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.vo.CommentVo;

/**
 * �Զ������۵����ݷ��ʲ�
 * @author ���Ĳ�
 * @time:2018��5��14�� ����10:57:13
 * @Description:TODO
 */

public interface CustomCommentMapper {
	/**
	 * ���ȸ���comment���topic_type����ȷ�����׺����ű��е���һ�Ź����� Ȼ�����topic_idȷ�����е�comment
	 * @param commentVo
	 * topic_type   1Ϊuser, 2Ϊskill, 3Ϊneed
	 * @return 
	 * List<CommentExpand>
	 */
	List<CommentExpand> queryCommentsByTopicId(CommentVo commentVo) throws Exception;
	/**
	 * 
	 * @param customExpand 
	 * �������ݣ������Զ�������key
	 * void
	 */
	void insertAndReturnKey(CommentVo customVo) throws Exception;
	
	
}
