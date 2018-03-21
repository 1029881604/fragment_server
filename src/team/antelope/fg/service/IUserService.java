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
	 * �ṩע�����
	 * @param user
	 * @throws UserExistException 
	 * void
	 */
	void register(User user) throws UserExistException;
	/**
	 * �ṩ�������
	 * @param name
	 * @param password 
	 * void �û�������
	 */
	Person login(String account, String password) 
			throws UserNameNotFoundException, UserPasswordErrorException;
	
	Person loginByAccount(String account, String password) 
			throws UserNameNotFoundException, UserPasswordErrorException;
	
	Person loginById(Long id, String password)
			throws UserNameNotFoundException, UserPasswordErrorException;
	
	/**
	 * �����û�����
	 * @return 
	 * List<User>
	 */
	List<PersonInfo> findFriend(Person person);
	/**
	 * ��ȡ�����б�
	 * @return 
	 * PublishSkill
	 */
	List<SkillPreInfo> getSkillProInfoList();
//	List<SkillPreInfo> getSkillProInfoList(int from, int to);
	List<NeedPreInfo> getNeedProInfoList();
	
	PublishSkill getSkill(long id);
	PublishNeed getNeed(long id);
	
}
