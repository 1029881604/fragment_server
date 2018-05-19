package team.antelope.fg.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.biz.ISkillService;
import team.antelope.fg.mapper.custom.CustomSkillMapper;
import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.SkillVo;
import team.antelope.fg.util.common.P2PUtil;

public class SkillServiceImpl implements ISkillService {

	@Autowired
	private CustomSkillMapper customSkillMapper;
	
	@Override
	public List<SkillExpand> getNearbySkillPreInfos(String type, Double latitude, Double longitude, SkillVo skillVo) throws Exception {
		skillVo.getSkillExpand().setSkilltype(type);
		skillVo.getSkillExpand().setLatitude(latitude);
		skillVo.getSkillExpand().setLongitude(longitude);
		return customSkillMapper.queryNearbyInfos(skillVo);
	}

	@Override
	public SkillExpand getSkillInfoById(Long id, Double latitude, Double longitude)throws Exception {
		//数据库中查询出数据
		SkillExpand skillExpand = customSkillMapper.querySkillInfoById(id);
		//对比计算距离
		Double distance = P2PUtil.getExactDistance(latitude, longitude,
		skillExpand.getLatitude(), skillExpand.getLongitude());
		//设置距离
		skillExpand.setDistance(distance);
		return skillExpand;
	}

	@Override
	public List<SkillExpand> getSkillInfosByPerson(Long uid, SkillVo skillVo) throws Exception {
		skillVo.getSkillExpand().setUid(uid);
		List<SkillExpand> list = customSkillMapper.querySkillInfosByPerson(skillVo);
		return list;
	}

}
