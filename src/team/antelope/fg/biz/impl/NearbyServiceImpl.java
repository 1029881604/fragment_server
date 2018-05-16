package team.antelope.fg.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.biz.INearbyService;
import team.antelope.fg.mapper.NearbymodularMapper;
import team.antelope.fg.mapper.PersonInfoMapper;
import team.antelope.fg.mapper.custom.CustomNeedMapper;
import team.antelope.fg.mapper.custom.CustomSkillMapper;
import team.antelope.fg.pojo.Nearbymodular;
import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.NeedVo;
import team.antelope.fg.pojo.vo.SkillVo;

public class NearbyServiceImpl implements INearbyService {

	//modularInfoMapper
	
	@Autowired
	private NearbymodularMapper nearbymodularMapper;
	

	@Override
	public Nearbymodular getNearbyModularInfo(String type) {
		 return nearbymodularMapper.selectByPrimaryKey(type);
	}



}
