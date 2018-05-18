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
	 * 关注某人
	 * @param attention 
	 * void
	 */
	void followPerson(AttentionKey attention) throws Exception;
	
	AttentionKey checkFollowStatus(AttentionKey attention) throws Exception;
}
