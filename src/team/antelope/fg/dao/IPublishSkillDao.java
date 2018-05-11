package team.antelope.fg.dao;


import java.util.List;

import team.antelope.fg.entity.PersonSkill;
import team.antelope.fg.entity.PublishSkill;

public interface IPublishSkillDao extends IBaseDao<PublishSkill> {
    List<PublishSkill> queryAllPublishSkill();    //
    int queryTotalRecords();    //
    List <PublishSkill> queryAllPublishSkill(int from, int to);//
	
    List<PublishSkill> queryOnlineSkillsByType(String type);
    
    //lry
  	List<PersonSkill> queryAllPersonSkill();
  	
  	//kyrene
  	List<PublishSkill> querySkillsByPerson(Long id);
}
