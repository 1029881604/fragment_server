package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.PersonInfoExpand;
import team.antelope.fg.pojo.vo.PersonInfoVo;

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
	/**
	 * 1.��ѯ�û�a��ע����     
	 * @param personInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> getFollowedUsers(PersonInfoVo personInfoVo) throws Exception;
	/**
	 * 2.��ѯ��ע�û�a����
	 * @param personInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> getFollowers(PersonInfoVo personInfoVo) throws Exception;
	/**
	 *  3.��ѯ��a�໥��ע����
	 * @param aInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> getFriends(PersonInfoVo aInfoVo) throws Exception;
}
