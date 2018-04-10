package team.antelope.fg.service.impl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

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
		System.out.println("�ҵ���"+"---------���뿪ʼ");
		person.setAge(Integer.parseInt(age));
		System.out.println(age);
		person.setEmail(email);
		System.out.println(email);
		person.setName(name);
		System.out.println(name);
		person.setSex(sex);
		
		setPersonDefault(person);
		personDao.update(person);
		System.out.println(sex+"---------�������");
		return  person;
	}
	/**
	 * ��ע���û�����Ĭ����Ϣ
	 * @param person 
	 * void
	 */
	private void setPersonDefault(Person person) {
		if(person.getHeadimg() == null){
			person.setPhonenum(UUID.randomUUID().toString().substring(0, 11));
			person.setHeadimg("img");
			person.setStarnum(0.0f);
			person.setDealnum(0);
			person.setFansnum(0);
		}
	}







}
