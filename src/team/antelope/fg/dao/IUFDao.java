package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.Attention;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;

public interface IUFDao extends IBaseDao<Attention> {
	List<PersonInfo> findFriendsAll(Person person);
	int getTotalRecords();
	public List<Attention> queryAll();
	public Attention queryById(long uid, long attentionuserid);  // add by 17/12/30 
}
