package team.antelope.fg.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.biz.ISkillService;
import team.antelope.fg.mapper.custom.CustomSkillMapper;
import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.SkillVo;

public class SkillServiceImpl implements ISkillService {

	@Autowired
	private CustomSkillMapper customSkillMapper;
	
	@Override
	public List<SkillExpand> getNearbySkillPreInfos(String type, Double latitude, Double longitude, SkillVo skillVo) {
		skillVo.getSkillExpand().setSkilltype(type);
		skillVo.getSkillExpand().setLatitude(latitude);
		skillVo.getSkillExpand().setLongitude(longitude);
		return customSkillMapper.queryNearbyInfos(skillVo);
	}

}
