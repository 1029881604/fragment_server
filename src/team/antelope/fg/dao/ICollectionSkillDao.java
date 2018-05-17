package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.CollectionSkill;

/**
 * �ղؼ���dao�ӿ�
 * @author ���Ĳ�\����
 * @time:2018��5��11�� ����2:19:12
 * @Description:TODO
 */
public interface ICollectionSkillDao extends IBaseDao<CollectionSkill>{
	/**
	 * �����û�id��ѯ�ղؼ��ܼ�¼
	 * List<CollectionSkill>
	 */
	List<CollectionSkill> queryCollectsByUserId(Long userId);
	
	/**
	 * Create by lx
	 * ����Ƿ���ڸ�����¼�����Ƿ��Ѿ��ղأ�
	 * @param userId
	 * @param skillId
	 * @return
	 */
	int queryJudgeSkillExist(Long userId, Long skillId);
	
	/**
	 * Create by lx
	 * ����user_id, skill_idɾ����Ӧ�ղ�����
	 * @param user_id
	 * @param skill_id
	 * @return
	 */
	int deleteByUseridSkillId(Long user_id, Long skill_id);
	
	/**
	 * Create by lx
	 * ����user_id, skill_id����ղ�����
	 * @param user_id
	 * @param skill_id
	 * @return
	 */
	int addByUseridSkillId(Long user_id, Long skill_id);
}
