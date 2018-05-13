package team.antelope.fg.service.simpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.mapper.NearbymodularMapper;
import team.antelope.fg.mapper.PersonInfoMapper;
import team.antelope.fg.mapper.custom.CustomNeedMapper;
import team.antelope.fg.mapper.custom.CustomSkillMapper;
import team.antelope.fg.pojo.Nearbymodular;
import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.NeedVo;
import team.antelope.fg.pojo.vo.PersonInfoVo;
import team.antelope.fg.pojo.vo.SkillVo;
import team.antelope.fg.service.ISNearbyService;

public class NearbyService implements ISNearbyService {

	//注入needMapper, skillMapper,modularInfoMapper,  personMapper
	@Autowired
	private CustomNeedMapper customNeedMapper;
	@Autowired
	private CustomSkillMapper customSkillMapper;
	@Autowired
	private NearbymodularMapper nearbymodularMapper;
	@Autowired
	private PersonInfoMapper personInfoMapper;
	
	
	@Override
	public List<NeedExpand> getNearbyNeedPreInfos(String type, Double latitude, Double longitude, NeedVo needVo) {
		needVo.getNeedExpand().setNeedtype(type);
		needVo.getNeedExpand().setLatitude(latitude);
		needVo.getNeedExpand().setLongitude(longitude);
		return customNeedMapper.queryNearbyInfos(needVo);
	}

	@Override
	public List<SkillExpand> getNearbySkillPreInfos(String type, Double latitude, Double longitude, SkillVo skillVo) {
		skillVo.getSkillExpand().setSkilltype(type);
		skillVo.getSkillExpand().setLatitude(latitude);
		skillVo.getSkillExpand().setLongitude(longitude);
		return customSkillMapper.queryNearbyInfos(skillVo);
	}

	@Override
	public Nearbymodular getNearbyModularInfo(String type) {
		 return nearbymodularMapper.selectByPrimaryKey(type);
	}

	/**
	 * 通过id获取用户信息
	 */
	@Override
	public PersonInfo getPersonInfo(Long id) {
		return personInfoMapper.selectByPrimaryKey(id);
	}

}
