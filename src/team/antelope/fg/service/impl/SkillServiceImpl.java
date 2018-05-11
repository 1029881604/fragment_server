package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.IPublishSkillDao;
import team.antelope.fg.dao.impl.PublishSkillDaoImpl;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.service.ISkillService;

/**
 * CreateBy:lx
 * Time:2018/4/3
 * 
 * */

public class SkillServiceImpl implements ISkillService {
	
	private IPublishSkillDao publishSkillDao = new PublishSkillDaoImpl();

	@Override
	public PublishSkill getPublishSkillInfosById(long id) {
		return publishSkillDao.queryById(id);
	}
	
	@Override
	public List<PublishSkill> getPublishSkillInfos() {
		return publishSkillDao.queryAllPublishSkill();
	}

	@Override
	public int getTotalRecords() {
		return publishSkillDao.queryTotalRecords();
	}

	@Override
	public List<PublishSkill> getPublishSkillInfos(int from, int to) {
		return publishSkillDao.queryAllPublishSkill(from, to);
	}

	@Override
	public List<PublishSkill> getOnlineSkillsByType(String type) {
		return publishSkillDao.queryOnlineSkillsByType(type);
	}

	@Override
	public List<PublishSkill> getSkillsByPerson(long id) {
		// TODO Auto-generated method stub
		return publishSkillDao.querySkillsByPerson(id);
	}

}
