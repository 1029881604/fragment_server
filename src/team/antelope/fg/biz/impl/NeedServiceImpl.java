package team.antelope.fg.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.antelope.fg.biz.INeedService;
import team.antelope.fg.mapper.custom.CustomNeedMapper;
import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.vo.NeedVo;
import team.antelope.fg.util.common.P2PUtil;

public class NeedServiceImpl implements INeedService {
	@Autowired
	private CustomNeedMapper customNeedMapper;
	
	@Override
	public List<NeedExpand> getNearbyNeedPreInfos(String type, Double latitude, Double longitude, NeedVo needVo) {
		needVo.getNeedExpand().setNeedtype(type);
		needVo.getNeedExpand().setLatitude(latitude);
		needVo.getNeedExpand().setLongitude(longitude);
		return customNeedMapper.queryNearbyInfos(needVo);
	}

	@Override
	public NeedExpand getNeedInfoById(Long id, Double latitude, Double longitude) {
		//���ݿ��в�ѯ������
		NeedExpand needExpand = customNeedMapper.queryNeedInfoById(id);
		//�Աȼ������
		Double distance = P2PUtil.getExactDistance(latitude, longitude,
				needExpand.getLatitude(), needExpand.getLongitude());
		//���þ���
		needExpand.setDistance(distance);
		return needExpand;
	}

	@Override
	public List<NeedExpand> getNeedInfosByPerson(Long uid, NeedVo needVo) throws Exception {
		//����uid
		needVo.getNeedExpand().setUid(uid);
		List<NeedExpand> list = customNeedMapper.queryNeedInfosByPerson(needVo);
		return list;
	}

}
