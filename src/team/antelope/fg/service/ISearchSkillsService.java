package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.entity.PublishSkill;

public interface ISearchSkillsService {
	List<PublishSkill> getSearchResult(String keyword);
}
