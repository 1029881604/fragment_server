package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.expand.PersonInfoExpand;
import team.antelope.fg.pojo.vo.PersonInfoVo;

/**
 * 用户数据访问
 * @author 华文财
 * @time:2018年5月17日 上午11:04:35
 * @Description:TODO
 */
public interface CustomPersonMapper {
	/**
	 * 通过用户名和密码查询
	 * @param p
	 * @return 
	 * Person
	 */
	Person selectByNameAndPassword(Person person);
	/**
	 * 1.查询用户a关注的人     
	 * @param personInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> queryFollowedUsers(PersonInfoVo personInfoVo) throws Exception;
	/**
	 * 2.查询关注用户a的人
	 * @param personInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> queryFollowers(PersonInfoVo personInfoVo) throws Exception;
	/**
	 *  3.查询和a相互关注的人
	 * @param aInfoVo
	 * @return
	 * @throws Exception 
	 * List<PersonInfoExpand>
	 */
	List<PersonInfoExpand> queryFriends(PersonInfoVo aInfoVo) throws Exception;
	
}
