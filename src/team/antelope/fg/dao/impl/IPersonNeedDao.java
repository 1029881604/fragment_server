package team.antelope.fg.dao.impl;

import java.util.List;

import team.antelope.fg.entity.PersonNeed;

/**
 * @author uniquelry
 * @Date 2018��4��9�� ����11:22:29
 * @Description 
 */
public interface IPersonNeedDao {
	/**
	 * ��ѯ���еĸ�����Ϣ������
	 * @return
	 */
	List<PersonNeed> queryAllPersonNeed();

}
