package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.entity.PersonNeed;
import team.antelope.fg.entity.PersonSkill;

/**
 * @author uniquelry
 * @Date 2018��4��9�� ����11:16:55
 * @Description 
 */
public interface IPublishService {
	List<PersonSkill> getAllPersonSkill();
	List<PersonNeed> getAllPersonNeed();
}
