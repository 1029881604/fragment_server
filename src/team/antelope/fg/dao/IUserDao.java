package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.User;

public interface IUserDao extends IBaseDao<User> {
	int getTotalRecords();
	List<User> findAll(); 
	List<User> findAll(int from, int to);
	//���ֶ�һ�޶�
	User findByName(String name);
	List<User> findUsersByLike(String name);
}
