package team.antelope.fg.service;

import team.antelope.fg.entity.CollectionSkill;

/**
 * �ղؼ��ܷ���ӿ�
 * @author ����
 *
 */
public interface SkillCollectService {

	//�ж��Ƿ����
	boolean judgeSkillExist(String m, String n);
	//ȡ���ղ�
	int cancelCollection(String user_id, String skill_id);
	//����ղ�
	int addCollection(String user_id, String skill_id);
	
}
