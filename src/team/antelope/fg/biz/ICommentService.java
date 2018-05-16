package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.vo.CommentVo;

/**
 * ���۷���ӿ�
 * @author ���Ĳ�
 * @time:2018��5��16�� ����9:38:22
 * @Description:TODO
 */
public interface ICommentService {
	/**
	 * @param comment
	 * @param topic_type   1Ϊuser, 2Ϊskill, 3Ϊneed
	 * @return 
	 * List<Comment>
	 */
	List<CommentExpand> getCommentsByTopicId(Long topicId, Short topicType, CommentVo commentVo);

}
