package team.antelope.fg.dao.impl;

import java.util.List;

import team.antelope.fg.dao.IPersonSkillDao;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.entity.PersonSkill;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

/**
 * @author uniquelry
 * @Date 2018年4月9日 下午11:21:08
 * @Description 
 */
public class PersonSkillDaoImpl implements IPersonSkillDao {

	@Override
	@SuppressWarnings(value="all")
	public List<PersonSkill> queryAllPersonSkill() {
		List<PersonSkill> psersonSkills = (List<PersonSkill>) DBUtil.exeQuery("select s.id, s.uid, s.title, s.content, s.publishdate, s.stopdate, " + 
				" s.img, s.skilltype, s.iscomplete, s.isonline, s.addressdesc, " + 
				" p.name, p.email, p.headimg, p.starnum, p.phonenum, p.dealnum, p.fansnum " + 
				" from publishskill s , person p" + 
				" WHERE s.uid = p.id; ",
				null,
				new BeanListHandler(PersonSkill.class));
		return psersonSkills;
	}
	
}
