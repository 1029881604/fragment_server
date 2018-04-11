package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.IPersonInfoDao;
import team.antelope.fg.dao.impl.NearbyModularInfoDaoImpl;
import team.antelope.fg.dao.impl.NeedPreInfoDaoImpl;
import team.antelope.fg.dao.impl.PersonInfoDaoImpl;
import team.antelope.fg.dao.impl.SkillPreInfoDaoImpl;
import team.antelope.fg.entity.NearbyModularInfo;
import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.entity.SkillPreInfo;
import team.antelope.fg.service.INearbyService;

public class NearbyServiceImpl implements INearbyService {

	private static NeedPreInfoDaoImpl needPreDao = new NeedPreInfoDaoImpl();
	private static SkillPreInfoDaoImpl skillPreDao = new SkillPreInfoDaoImpl();
	private static NearbyModularInfoDaoImpl modularInfo = new NearbyModularInfoDaoImpl();
	private static IPersonInfoDao personInfoDao = new PersonInfoDaoImpl();
	
	@Override
	public List<NeedPreInfo> getNearbyNeedPreInfos(String type, double latitude, double longitude) {
		// TODO 自动生成的方法存根
		List<NeedPreInfo> infos = needPreDao.queryNearbyInfos(type, latitude, longitude);
		return infos;
	}

	@Override
	public List<SkillPreInfo> getNearbySkillPreInfos(String type, double latitude, double longitude) {
		// TODO 自动生成的方法存根
		return skillPreDao.queryNearbyInfos(type, latitude, longitude);
	}

	@Override
	public NearbyModularInfo getNearbyModularInfo(String type) {
		// TODO 自动生成的方法存根
		return modularInfo.queryByType(type);
	}

	/**
	 * 通过id获取用户信息
	 */
	@Override
	public PersonInfo getPersonInfo(long id) {
		return personInfoDao.queryById(id);
	}

}
