package team.antelope.fg.dao;


import java.util.List;

import team.antelope.fg.entity.PersonSkill;
import team.antelope.fg.entity.PublishSkill;

/**
 * 
 * @author 华文财
 * @time:2017年12月29日 下午11:21:16
 * @Description:TODO
 */

public interface IPublishSkillDao extends IBaseDao<PublishSkill> {
    List<PublishSkill> queryAllPublishSkill();    //
    int queryTotalRecords();    //
    List <PublishSkill> queryAllPublishSkill(int from, int to);//
	/**
	 * 通过类型查询所有在线技能
	 * @param type
	 * @return 
	 * List<PublishSkill>
	 */
    List<PublishSkill> queryOnlineSkillsByType(String type);
    
    //lry添加 查询所有的。。实体类
  	List<PersonSkill> queryAllPersonSkill();
}
