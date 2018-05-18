package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.Comment;
import team.antelope.fg.pojo.Person;
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
	List<CommentExpand> getCommentsByTopicId(Long topicId, Short topicType, CommentVo commentVo) throws Exception;
	/**
	 * 异步添加需求评论
	 * @param topicId  被评论的id
	 * @param topicType	被评论的类型
	 * @param uid		评论者id
	 * @param CommentVo	评论实体vo
	 * @throws Exception   
	 * 因为是异步，所以要更新的返回给视图显示
	 * void
	 */
	CommentExpand saveNeedCommentsAsync(Short topicType, Person user, CommentVo commentVo) throws Exception;
	/**
	 * 异步添加技能评论
	 * @param topicId  被评论的id
	 * @param topicType	被评论的类型
	 * @param uid		评论者id
	 * @param CommentVo	评论实体vo
	 * @throws Exception   
	 * 因为是异步，所以要更新的返回给视图显示
	 * void
	 */
	CommentExpand saveSkillCommentsAsync(Short topicType, Person user, CommentVo commentVo) throws Exception;
}
