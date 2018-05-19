package team.antelope.fg.biz.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.antelope.fg.biz.IPersonService;
import team.antelope.fg.mapper.PersonInfoMapper;
import team.antelope.fg.mapper.custom.CustomPersonMapper;
import team.antelope.fg.pojo.Person;
import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.PersonInfoExpand;
import team.antelope.fg.pojo.vo.PersonInfoVo;
import team.antelope.fg.util.DateUtil;
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

	@Override
	public List<PersonInfoExpand> getFollowedUsers(PersonInfoVo personInfoVo) throws Exception {
		// 业务处理...可以按关注时间查询之类的
		List<PersonInfoExpand> followedUsers = customePersonMapper.queryFollowedUsers(personInfoVo);
		followedUsers.forEach(p->{
			long current = System.currentTimeMillis();
			String beginDate = DateUtil.formatDataTime2(new Date(current - (long)1000*3600*24*365*3));
			String endDate = DateUtil.formatDataTime2(new Date(current));
			Date randomDate = DateUtil.randomDate(beginDate, endDate);
			p.setFollowTime(randomDate);
		});
		return followedUsers;
	}

	@Override
	public List<PersonInfoExpand> getFollowers(PersonInfoVo personInfoVo) throws Exception {
		return customePersonMapper.queryFollowers(personInfoVo);
	}

	@Override
	public List<PersonInfoExpand> getFriends(PersonInfoVo aInfoVo) throws Exception {
		return customePersonMapper.queryFriends(aInfoVo);
	}

}
