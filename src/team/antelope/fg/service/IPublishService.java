package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.entity.PersonNeed;
import team.antelope.fg.entity.PersonSkill;
import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.entity.PublishSkill;

/**
 * @author uniquelry
 * @Date 2018年4月9日 下午11:16:55
 * @Description 发布相关服务的接口
 */
public interface IPublishService {
	List<PersonSkill> getAllPersonSkill();
	List<PersonNeed> getAllPersonNeed();
	int publishNeed(PublishNeed need);
	int publishSkill(PublishSkill skill);
}
