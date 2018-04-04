package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.impl.PublishSkillDaoImpl;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.service.ISkillService;

/**
 * CreateBy:lx
 * Time:2018/4/3
 * 
 * */

public class SkillServiceImpl implements ISkillService {
	
	private PublishSkillDaoImpl publishSkillDaoImpl = new PublishSkillDaoImpl();

	@Override
	public PublishSkill getPublishSkillInfosById(long id) {
		// TODO Auto-generated method stub
		return publishSkillDaoImpl.queryById(id);
	}
	
	@Override
	public List<PublishSkill> getPublishSkillInfos() {
		// TODO Auto-generated method stub
		return publishSkillDaoImpl.queryAllPublishSkill();
	}

	@Override
	public int getTotalRecords() {
		// TODO Auto-generated method stub
		return publishSkillDaoImpl.queryTotalRecords();
	}

	@Override
	public List<PublishSkill> getPublishSkillInfos(int from, int to) {
		// TODO Auto-generated method stub
		return publishSkillDaoImpl.queryAllPublishSkill(from, to);
	}

}
