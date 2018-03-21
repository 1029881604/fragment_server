package team.antelope.fg.dao;


import java.util.List;

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
}
