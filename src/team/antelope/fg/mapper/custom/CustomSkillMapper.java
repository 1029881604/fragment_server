package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.SkillVo;

public interface CustomSkillMapper {
	/**
	 * 获取附近的技能预览信息列表
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedVo>
	 */
	List<SkillExpand> queryNearbyInfos(SkillVo skillVo);
	/**
	 * 根据id联合查询skill和person相关信息
	 * @param id
	 * @return 
	 * SkillExpand
	 */
	SkillExpand querySkillInfoById(Long id);
	/**
	 * 根据用户id查询所属的技能部分字段信息
	 * @param skillVo
	 * @return 
	 * List<SkillExpand>
	 */
	List<SkillExpand> querySkillInfosByPerson(SkillVo skillVo);
}
