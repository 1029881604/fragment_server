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
	/**
	 * 根据类型查询所有的线上技能
	 * @return 
	 * List<PublishSkill>
	 */
	List<PublishSkill> getOnlineSkillsByType(String type);

}
