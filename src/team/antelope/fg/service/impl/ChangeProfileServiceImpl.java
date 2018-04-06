package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.impl.PersonDaoImpl;
import team.antelope.fg.dao.impl.PersonInfoDaoImpl;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.service.IChangeProfileService;



public class ChangeProfileServiceImpl implements IChangeProfileService {

	PersonDaoImpl personDao= new PersonDaoImpl();

	@Override
	public Person ChangeProfileService(String id, String name, String email, String age, String sex) {
		// TODO Auto-generated method stub
		
		Person person = personDao.queryById(Long.parseLong(id));
		System.out.println("找到了"+"---------插入开始");
		person.setAge(Integer.parseInt(age));
		System.out.println(age);
		person.setEmail(email);
		System.out.println(email);
		person.setName(name);
		System.out.println(name);
		person.setSex(sex);
		personDao.update(person);
		System.out.println(sex+"---------插入结束");
		return  person;
	}







}
