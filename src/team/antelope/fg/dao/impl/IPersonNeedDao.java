package team.antelope.fg.dao.impl;

import java.util.List;

import team.antelope.fg.entity.PersonNeed;

/**
 * @author uniquelry
 * @Date 2018年4月9日 下午11:22:29
 * @Description 
 */
public interface IPersonNeedDao {
	/**
	 * 查询所有的个人信息和需求
	 * @return
	 */
	List<PersonNeed> queryAllPersonNeed();

}
