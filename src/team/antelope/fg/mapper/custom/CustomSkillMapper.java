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

}
