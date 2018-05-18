package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.expand.PersonInfoExpand;
import team.antelope.fg.pojo.vo.PersonInfoVo;

/**
 * �û����ݷ���
 * @author ���Ĳ�
 * @time:2018��5��17�� ����11:04:35
 * @Description:TODO
 */
public interface CustomPersonMapper {
	/**
	 * ͨ���û����������ѯ
	 * @param p
	 * @return 
	 * Person
	 */
	Person selectByNameAndPassword(Person person);
	/**
	 * 1.��ѯ�û�a��ע����     
	 * @param personInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> queryFollowedUsers(PersonInfoVo personInfoVo) throws Exception;
	/**
	 * 2.��ѯ��ע�û�a����
	 * @param personInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> queryFollowers(PersonInfoVo personInfoVo) throws Exception;
	/**
	 *  3.��ѯ��a�໥��ע����
	 * @param aInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> queryFriends(PersonInfoVo aInfoVo) throws Exception;
	
}
