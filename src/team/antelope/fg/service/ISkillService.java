package team.antelope.fg.service;

import java.util.List;
import team.antelope.fg.entity.PublishSkill;

/**
 * CreateBy:lx
 * Time:2018/4/3
 * 
 * */
public interface ISkillService {
	
	PublishSkill getPublishSkillInfosById(long id);
	
	List<PublishSkill> getPublishSkillInfos();
	
	int getTotalRecords();
	
	List<PublishSkill> getPublishSkillInfos(int from, int to);
	


}
