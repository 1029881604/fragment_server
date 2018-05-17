package team.antelope.fg.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.antelope.fg.biz.IPersonService;
import team.antelope.fg.mapper.PersonInfoMapper;
import team.antelope.fg.mapper.custom.CustomPersonMapper;
import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.PersonInfo;
@Service("personService")
public class PersonServiceImpl implements IPersonService{

	@Autowired
	private PersonInfoMapper personInfoMapper;
	@Autowired
	private CustomPersonMapper customePersonMapper;
	
	
	/**
	 * 通过id获取用户信息
	 */
	@Override
	public PersonInfo getPersonInfo(Long id) {
		return personInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public Person loginByName(String account, String password) {
		Person p = new Person();
		p.setName(account);
		p.setPassword(password);
		return customePersonMapper.selectByNameAndPassword(p);
	}

}
