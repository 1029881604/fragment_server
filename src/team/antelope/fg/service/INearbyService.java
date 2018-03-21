package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.entity.NearbyModularInfo;
import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.SkillPreInfo;

public interface INearbyService {
	/**
	 * 获取附近的需求预览信息列表
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedPreInfo>
	 */
	List<NeedPreInfo> getNearbyNeedPreInfos(String type, double latitude,
			double longitude);
	/**
	 * 获取附近的技能服务预览信息列表
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<SkillPreInfo>
	 */
	List<SkillPreInfo> getNearbySkillPreInfos(String type, double latitude,
			double longitude);
	
	/**
	 * 获取附近板块的模块信息
	 * @param type
	 * @return 
	 * NearbyModularInfo
	 */
	NearbyModularInfo getNearbyModularInfo(String type);
}
