package team.antelope.fg.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.biz.IPersonService;
import team.antelope.fg.mapper.PersonInfoMapper;
import team.antelope.fg.pojo.PersonInfo;

public class PersonServiceImpl implements IPersonService{

	@Autowired
	private PersonInfoMapper personInfoMapper;
	
	/**
	 * ͨ��id��ȡ�û���Ϣ
	 */
	@Override
	public PersonInfo getPersonInfo(Long id) {
		return personInfoMapper.selectByPrimaryKey(id);
	}

}
