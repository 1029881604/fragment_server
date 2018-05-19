package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.CollectionSkill;

/**
 * 收藏技能dao接口
 * @author 华文财\廖翔
 * @time:2018年5月11日 下午2:19:12
 * @Description:TODO
 */
public interface ICollectionSkillDao extends IBaseDao<CollectionSkill>{
	/**
	 * 根据用户id查询收藏技能记录
	 * List<CollectionSkill>
	 */
	List<CollectionSkill> queryCollectsByUserId(Long userId);
	
	/**
	 * Create by lx
	 * 检查是否存在该条记录（即是否已经收藏）
	 * @param userId
	 * @param skillId
	 * @return
	 */
	int queryJudgeSkillExist(Long userId, Long skillId);
	
	/**
	 * Create by lx
	 * 根据user_id, skill_id删除响应收藏数据
	 * @param user_id
	 * @param skill_id
	 * @return
	 */
	int deleteByUseridSkillId(Long user_id, Long skill_id);
	
	/**
	 * Create by lx
	 * 根据user_id, skill_id添加收藏数据
	 * @param user_id
	 * @param skill_id
	 * @return
	 */
	int addByUseridSkillId(Long user_id, Long skill_id);
}
