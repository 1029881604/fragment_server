package team.antelope.fg.biz;

import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.PersonInfo;

public interface IPersonService {
	/**
	 * ͨ��id���Ҹ�����Ϣ
	 * @param id
	 * @return 
	 * PersonInfo
	 */
	PersonInfo getPersonInfo(Long id);
	/**
	 * �Զ������
	 * @param account
	 * @param password
	 * @return 
	 * Person
	 */
	Person loginByName(String account, String password);
}
