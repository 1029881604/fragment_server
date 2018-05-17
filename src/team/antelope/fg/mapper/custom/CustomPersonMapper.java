package team.antelope.fg.mapper.custom;

import team.antelope.fg.pojo.Person;

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
}
