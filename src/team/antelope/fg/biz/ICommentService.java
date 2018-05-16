package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.vo.CommentVo;

/**
 * 评论服务接口
 * @author 华文财
 * @time:2018年5月16日 上午9:38:22
 * @Description:TODO
 */
public interface ICommentService {
	/**
	 * @param comment
	 * @param topic_type   1为user, 2为skill, 3为need
	 * @return 
	 * List<Comment>
	 */
	List<CommentExpand> getCommentsByTopicId(Long topicId, Short topicType, CommentVo commentVo);

}
