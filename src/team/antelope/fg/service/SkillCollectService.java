package team.antelope.fg.service;

import team.antelope.fg.entity.CollectionSkill;

/**
 * 收藏技能服务接口
 * @author 廖翔
 *
 */
public interface SkillCollectService {

	//判断是否存在
	boolean judgeSkillExist(String m, String n);
	//取消收藏
	int cancelCollection(String user_id, String skill_id);
	//添加收藏
	int addCollection(String user_id, String skill_id);
	
}
