package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.IPublishSkillDao;
import team.antelope.fg.dao.impl.PublishSkillDaoImpl;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.service.ISearchSkillsService;

public class SearchSkillServiceImpl implements ISearchSkillsService {

	private IPublishSkillDao publishSkillDao = new PublishSkillDaoImpl();
	
	@Override
	public List<PublishSkill> getSearchResult(String keyword) {
		// TODO Auto-generated method stub
		return publishSkillDao.queryByKeyword(keyword);
	}

}
