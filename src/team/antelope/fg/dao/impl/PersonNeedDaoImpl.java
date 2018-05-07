package team.antelope.fg.dao.impl;

import java.util.List;

import team.antelope.fg.entity.PersonNeed;
import team.antelope.fg.entity.PersonSkill;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

/**
 * @author uniquelry
 * @Date 2018年4月9日 下午11:22:13
 * @Description 
 */
public class PersonNeedDaoImpl implements IPersonNeedDao{
	@Override
	@SuppressWarnings(value="all")
	public List<PersonNeed> queryAllPersonNeed() {
		List<PersonNeed> personNeeds = (List<PersonNeed>) DBUtil.exeQuery("select n.id, n.uid, n.title, n.content, n.customdate, n.requestdate, " + 
				" n.needtype, n.iscomplete, n.isonline, n.addressdesc, " + 
				" p.name, p.email, p.headimg, p.starnum, p.phonenum, p.dealnum, p.fansnum " + 
				" from publishneed n , person p " + 
				" WHERE n.uid = p.id; ",
				null,
				new BeanListHandler(PersonNeed.class));
		return personNeeds;
	}
	
}
