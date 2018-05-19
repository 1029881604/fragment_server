package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.IPublishNeedDao;
import team.antelope.fg.dao.IPublishSkillDao;
import team.antelope.fg.dao.impl.PublishNeedDaoImpl;
import team.antelope.fg.dao.impl.PublishSkillDaoImpl;
import team.antelope.fg.entity.PersonNeed;
import team.antelope.fg.entity.PersonSkill;
import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.service.IPublishService;

/**
 * @author uniquelry
 * @Date 2018年4月9日 下午11:16:23
 * @Description 发布相关服务的实现类
 */
public class PublishServiceImpl implements IPublishService {

	private IPublishSkillDao publishSkillDao = new PublishSkillDaoImpl();
	private IPublishNeedDao publishNeedDao = new PublishNeedDaoImpl();
	
	@Override
	public List<PersonSkill> getAllPersonSkill() {
		return publishSkillDao.queryAllPersonSkill();
	}

	@Override
	public List<PersonNeed> getAllPersonNeed() {
		return publishNeedDao.queryAllPersonNeed();
	}

	@Override
	public int publishNeed(PublishNeed need) {
		return publishNeedDao.insert(need);
	}

	@Override
	public int publishSkill(PublishSkill skill) {
		return publishSkillDao.insert(skill);
	}

}
