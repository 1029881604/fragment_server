package team.antelope.fg.service.impl;

import team.antelope.fg.dao.ICollectionSkillDao;
import team.antelope.fg.dao.impl.CollectionSkillDaoImpl;
import team.antelope.fg.entity.CollectionSkill;
import team.antelope.fg.service.SkillCollectService;

/**
 * 收藏技能服务实现类
 * @author 廖翔
 *
 */
public class SkillCollectServiceImpl implements SkillCollectService {

	ICollectionSkillDao collectionSkillDao = new CollectionSkillDaoImpl(); 
	
	@Override
	public boolean judgeSkillExist(String m, String n) {
		try {
			int flag = collectionSkillDao.queryJudgeSkillExist(Long.parseLong(m), Long.parseLong(n));
		if (flag == 1) {
			return true;
		}else {
		return false;
		}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public int cancelCollection(String user_id, String skill_id) {
		// TODO Auto-generated method stub
		try {
			System.out.println("已执行取消收藏");
			return collectionSkillDao.deleteByUseridSkillId(Long.parseLong(user_id), Long.parseLong(skill_id));
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int addCollection(String user_id, String skill_id) {
		// TODO Auto-generated method stub
		try {
			System.out.println("已执行收藏");
			return collectionSkillDao.addByUseridSkillId(Long.parseLong(user_id), Long.parseLong(skill_id));
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

}
