package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.SkillVo;

public interface ISkillService {
	/**
	 * 获取附近的技能服务预览信息列表
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<SkillPreInfo>
	 */
	List<SkillExpand> getNearbySkillPreInfos(String type, Double latitude,
			Double longitude, SkillVo skillVo) throws Exception;
	/**
	 * 获取技能信息之前要计算和技能发布时的距离
	 * 有业务逻辑
	 * @param id
	 * @return   技能比需求多了一个img字段
	 * SkillExpand
	 */
	SkillExpand getSkillInfoById(Long id, Double latitude, Double longitude) throws Exception;
	List<SkillExpand> getSkillInfosByPerson (Long uid, SkillVo skillVo) throws Exception;
}
