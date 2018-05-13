package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.pojo.Nearbymodular;
import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.NeedVo;
import team.antelope.fg.pojo.vo.PersonInfoVo;
import team.antelope.fg.pojo.vo.SkillVo;

public interface ISNearbyService {
	/**
	 * 获取附近的需求预览信息列表
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedPreInfo>
	 */
	List<NeedExpand> getNearbyNeedPreInfos(String type, Double latitude,
			Double longitude, NeedVo needVo);
	/**
	 * 获取附近的技能服务预览信息列表
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<SkillPreInfo>
	 */
	List<SkillExpand> getNearbySkillPreInfos(String type, Double latitude,
			Double longitude, SkillVo skillVo);
	/**
	 * 获取附近板块的模块信息
	 * @param type
	 * @return 
	 * NearbyModularInfo
	 */
	Nearbymodular getNearbyModularInfo(String type);
	/**
	 * 通过id查找个人信息
	 * @param id
	 * @return 
	 * PersonInfo
	 */
	PersonInfo getPersonInfo(Long id);
	
}
