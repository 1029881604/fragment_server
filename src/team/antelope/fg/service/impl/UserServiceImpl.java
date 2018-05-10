package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.impl.NeedPreInfoDaoImpl;
import team.antelope.fg.dao.impl.PersonDaoImpl;
import team.antelope.fg.dao.impl.PublishNeedDaoImpl;
import team.antelope.fg.dao.impl.PublishSkillDaoImpl;
import team.antelope.fg.dao.impl.SkillPreInfoDaoImpl;
import team.antelope.fg.dao.impl.UFDaoImpl;
import team.antelope.fg.dao.impl.UserDaoImpl;
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
import team.antelope.fg.service.IUserService;

public class UserServiceImpl implements IUserService {

	UserDaoImpl userDao = new UserDaoImpl();
	PersonDaoImpl personDao = new PersonDaoImpl();
	UFDaoImpl ufDao = new UFDaoImpl();
	PublishSkillDaoImpl skillDao = new PublishSkillDaoImpl();
	PublishNeedDaoImpl needDao = new PublishNeedDaoImpl();
	SkillPreInfoDaoImpl skillPreDao = new SkillPreInfoDaoImpl();
	NeedPreInfoDaoImpl needPreDao = new NeedPreInfoDaoImpl();
	@Override
	public void register(User user) throws UserExistException {
		// TODO 自动生成的方法存根
		if(userDao.findByName(user.getName()) != null){
			//这里抛编译时异常的原因：上一层程序处理这个异常，以给用户一个友好提示
			throw new UserExistException("注册的用户名已存在！！！");
		}
		userDao.insert(user);
	}
	
	/**
	 * 登入用户才有
	 */
	@Override
	public List<PersonInfo> findFriend(Person person) {
		// TODO 自动生成的方法存根
		List <PersonInfo> users = ufDao.findFriendsAll(person);
		return users;
	}
	
	@Deprecated
	@Override
	public Person login(String account, String password) 
			throws UserNameNotFoundException, UserPasswordErrorException {
		// TODO 自动生成的方法存根
		Person person = personDao.queryByName(account);
		if(person == null){
			person = personDao.queryByEmail(account);
			if(person == null){
				person = personDao.queryByPhoneNum(account);
				if(person == null){
//					person = personDao.queryById(Long.parseLong(account));//不用id
//					if(person == null){
						throw new UserNameNotFoundException("账号不存在");
//					}
				}
			}
		} else if(!person.getPassword().equals(password)){
			throw new UserPasswordErrorException("密码错误");
		} 
		return person;
	}



	@Override
	public Person loginByAccount(String account, String password)
			throws UserNameNotFoundException, UserPasswordErrorException {
		// TODO 自动生成的方法存根
		
		//////////////////////////////////////用存储过程，在mysql 中判断
		
		return null;
	}

	@Override
	public Person loginById(Long id, String password) 
			throws UserNameNotFoundException, UserPasswordErrorException {
		// TODO 自动生成的方法存根
		Person person = personDao.queryById(id);
		if(person == null){
			throw new UserNameNotFoundException();
		} else if(!person.getPassword().equals(password)){
			throw new UserPasswordErrorException();
		}
		return person;
	}

	@Override
	public List<SkillPreInfo> getSkillProInfoList() {
		// TODO 自动生成的方法存根
		List<SkillPreInfo> allSkillPreInfo = skillPreDao.queryAllSkillInfo();
		return allSkillPreInfo;
	}

	@Override
	public List<NeedPreInfo> getNeedProInfoList() {
		// TODO 自动生成的方法存根
		List<NeedPreInfo> allNeedPreInfo = needPreDao.queryAllNeedInfo();
		return allNeedPreInfo;
	}

	@Override
	public PublishSkill getSkill(long id) {
		return skillDao.queryById(id);
	}

	@Override
	public PublishNeed getNeed(long id) {
		return  needDao.queryById(id);
	}

	@Override
	public Person getUserPerson(long id) {
		return personDao.queryById(id);
	}

	
	
}








