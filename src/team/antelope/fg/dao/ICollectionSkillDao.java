package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.CollectionSkill;

/**
 * �ղؼ���dao�ӿ�
 * @author ���Ĳ�
 * @time:2018��5��11�� ����2:19:12
 * @Description:TODO
 */
public interface ICollectionSkillDao extends IBaseDao<CollectionSkill>{
	/**
	 * �����û�id��ѯ�ղؼ��ܼ�¼
	 * List<CollectionSkill>
	 */
	List<CollectionSkill> queryCollectsByUserId(Long userId);
}
