package team.antelope.fg.constant;
/**
 * request请求域放置的常量
 * @author 华文财
 * @time:2018年5月18日 下午4:50:03
 * @Description:TODO
 */
public interface RequestScopeConst {
	/**
	 * 用户关注他人的状态
	 * 关注成功/已经关注
	 */
	String FOLLOW_STATUS = "follow_status"; 
	/**
	 * 被关注的人
	 */
	String FOLLOWEDUSERS = "followedUsers";
	/**
	 * topic评论列表
	 */
	String COMMENTEXPANDLIST = "commentExpandList";
	/**
	 * 用户的所有需求列表
	 */
	String USER_ALL_NEEDINFO = "user_all_needinfo";
	/**
	 * 用户的所有需求列表
	 */
	String USER_ALL_SKILLINFO = "user_all_skillinfo";
	/**
	 * 将该查看的用户信息传入另一个页面
	 */
	String REQUEST_USER = "request_user";
	
}
