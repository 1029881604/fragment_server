package team.antelope.fg.constant;
/**
 * 数据库表中要用的常量
 * @author 华文财
 * @time:2018年5月17日 上午9:05:10
 * @Description:TODO
 */
public interface DBConst {
	//comment
	/**
	 * 评论表comment的topicType分类
	 *   '1为user，2为skill，3为need'   根据此类型关联表或为user或为skill/need，所以没有外键
	 */
	Short COMMENT_TOPICTYPE_USER = 1;
	Short COMMENT_TOPICTYPE_Skill = 2;
	Short COMMENT_TOPICTYPE_NEED = 3;
	/**
	 * 评论表comment的评论状态分类
	 * '评论状态，-1为删除，0为待审核，1为已发布'
	 */
	Short COMMENT_STATUS_DEL = -1;
	Short COMMENT_STATUS_CHECK = 0;
	Short COMMENT_STATUS_PUBLISH = 1;
	
	//comment_reply
	
	
}
