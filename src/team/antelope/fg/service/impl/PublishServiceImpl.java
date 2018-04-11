package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.IPersonSkillDao;
import team.antelope.fg.dao.impl.IPersonNeedDao;
import team.antelope.fg.dao.impl.PersonNeedDaoImpl;
import team.antelope.fg.dao.impl.PersonSkillDaoImpl;
import team.antelope.fg.entity.PersonNeed;
import team.antelope.fg.entity.PersonSkill;
import team.antelope.fg.service.IPublishService;

/**
 * @author uniquelry
 * @Date 2018年4月9日 下午11:16:23
 * @Description 
 */
public class PublishServiceImpl implements IPublishService {

	private IPersonSkillDao personSkillDao = new PersonSkillDaoImpl();
	private IPersonNeedDao personNeedDao = new PersonNeedDaoImpl();
	
	@Override
	public List<PersonSkill> getAllPersonSkill() {
		return personSkillDao.queryAllPersonSkill();
	}

	@Override
	public List<PersonNeed> getAllPersonNeed() {
		return personNeedDao.queryAllPersonNeed();
	}

}
