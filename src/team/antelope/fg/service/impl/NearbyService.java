package team.antelope.fg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.entity.NearbyModularInfo;
import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.entity.SkillPreInfo;
import team.antelope.fg.mapper.NeedMapper;
import team.antelope.fg.mapper.PersonMapper;
import team.antelope.fg.mapper.SkillMapper;
import team.antelope.fg.service.INearbyService;

public class NearbyService implements INearbyService {

	//ע��needMapper, skillMapper,modularInfoMapper,  personMapper
	@Autowired
	private NeedMapper needMapper;
	@Autowired
	private SkillMapper skillMapper;
	@Autowired
	private ModularI modularInfoMapper;
	@Autowired
	private PersonMapper personMapper;
	
	
	@Override
	public List<NeedPreInfo> getNearbyNeedPreInfos(String type, double latitude, double longitude) {
		// TODO �Զ����ɵķ������
		List<NeedPreInfo> infos = needPreDao.queryNearbyInfos(type, latitude, longitude);
		return infos;
	}

	@Override
	public List<SkillPreInfo> getNearbySkillPreInfos(String type, double latitude, double longitude) {
		// TODO �Զ����ɵķ������
		return skillPreDao.queryNearbyInfos(type, latitude, longitude);
	}

	@Override
	public NearbyModularInfo getNearbyModularInfo(String type) {
		// TODO �Զ����ɵķ������
		return modularInfo.queryByType(type);
	}

	/**
	 * ͨ��id��ȡ�û���Ϣ
	 */
	@Override
	public PersonInfo getPersonInfo(long id) {
		return personInfoDao.queryById(id);
	}

}
