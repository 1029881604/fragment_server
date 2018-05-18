package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.PersonInfoExpand;
import team.antelope.fg.pojo.vo.PersonInfoVo;

public interface IPersonService {
	/**
	 * 通过id查找个人信息
	 * @param id
	 * @return 
	 * PersonInfo
	 */
	PersonInfo getPersonInfo(Long id);
	/**
	 * 自定义登入
	 * @param account
	 * @param password
	 * @return 
	 * Person
	 */
	Person loginByName(String account, String password);
	/**
	 * 1.查询用户a关注的人     
	 * @param personInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> getFollowedUsers(PersonInfoVo personInfoVo) throws Exception;
	/**
	 * 2.查询关注用户a的人
	 * @param personInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> getFollowers(PersonInfoVo personInfoVo) throws Exception;
	/**
	 *  3.查询和a相互关注的人
	 * @param aInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> getFriends(PersonInfoVo aInfoVo) throws Exception;
}
