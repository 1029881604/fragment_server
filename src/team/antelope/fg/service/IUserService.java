package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.entity.SkillPreInfo;
import team.antelope.fg.entity.User;
import team.antelope.fg.exception.UserExistException;
import team.antelope.fg.exception.UserNameNotFoundException;
import team.antelope.fg.exception.UserPasswordErrorException;

public interface IUserService {
	/**
	 * 提供注册服务
	 * @param user
	 * @throws UserExistException 
	 * void
	 */
	void register(User user) throws UserExistException;
	/**
	 * 提供登入服务
	 * @param name
	 * @param password 
	 * void 用户名登入
	 */
	Person login(String account, String password) 
			throws UserNameNotFoundException, UserPasswordErrorException;
	
	Person loginByAccount(String account, String password) 
			throws UserNameNotFoundException, UserPasswordErrorException;
	
	Person loginById(Long id, String password)
			throws UserNameNotFoundException, UserPasswordErrorException;
	
	/**
	 * 查找用户好友
	 * @return 
	 * List<User>
	 */
	List<PersonInfo> findFriend(Person person);
	/**
	 * 获取技能列表
	 * @return 
	 * PublishSkill
	 */
	List<SkillPreInfo> getSkillProInfoList();
//	List<SkillPreInfo> getSkillProInfoList(int from, int to);
	List<NeedPreInfo> getNeedProInfoList();
	
	PublishSkill getSkill(long id);
	PublishNeed getNeed(long id);
	
	Person getUserPerson(long id);
	
}
