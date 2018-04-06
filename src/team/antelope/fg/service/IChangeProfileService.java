package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;

public interface IChangeProfileService {

	/**
	 * 修改用户资料
	 * @param name
	 * @param email
	 * @param age
	 * @param sex
	 * @return
	 */
	Person ChangeProfileService(String id,String name,String email, String age,String sex);
	
}
