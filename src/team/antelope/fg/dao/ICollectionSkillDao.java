package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.CollectionSkill;

/**
 * 收藏技能dao接口
 * @author 华文财
 * @time:2018年5月11日 下午2:19:12
 * @Description:TODO
 */
public interface ICollectionSkillDao extends IBaseDao<CollectionSkill>{
	/**
	 * 根据用户id查询收藏技能记录
	 * List<CollectionSkill>
	 */
	List<CollectionSkill> queryCollectsByUserId(Long userId);
}
