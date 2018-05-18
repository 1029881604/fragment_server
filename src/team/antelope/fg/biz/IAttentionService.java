package team.antelope.fg.biz;

import team.antelope.fg.pojo.AttentionKey;

/**
 * 关注服务接口
 * @author 华文财
 * @time:2018年5月18日 下午4:27:39
 * @Description:TODO
 */
public interface IAttentionService {
	/**
	 * 关注某人  (插入一条Attention数据)
	 * @param attention 
	 * void
	 */
	void followPerson(AttentionKey attention) throws Exception;
	/**
	 * 检查关注状态person1对person2  (查询一条Attention数据)
	 * 如果已经关注了就不用再关注
	 * @param attention
	 * @return
	 * @throws Exception 
	 * AttentionKey
	 */
	AttentionKey checkFollowStatus(AttentionKey attention) throws Exception;
	
}
