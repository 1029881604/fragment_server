package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.expand.CommentExpand;
import team.antelope.fg.pojo.vo.CommentVo;

/**
 * 自定义评论的数据访问层
 * @author 华文财
 * @time:2018年5月14日 上午10:57:13
 * @Description:TODO
 */

public interface CustomCommentMapper {
	/**
	 * 首先根据comment表的topic_type类型确定到底和三张表中的哪一张关联， 然后根据topic_id确定所有的comment
	 * @param commentVo
	 * topic_type   1为user, 2为skill, 3为need
	 * @return 
	 * List<CommentExpand>
	 */
	List<CommentExpand> queryCommentsByTopicId(CommentVo commentVo);
}
