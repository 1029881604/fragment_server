package team.antelope.fg.biz;

import team.antelope.fg.pojo.PersonInfo;

public interface IPersonService {
	/**
	 * 通过id查找个人信息
	 * @param id
	 * @return 
	 * PersonInfo
	 */
	PersonInfo getPersonInfo(Long id);
}
