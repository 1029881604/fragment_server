package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.vo.NeedVo;

public interface CustomNeedMapper {
	/**
	 * 获取附近的需求预览信息列表
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedVo>
	 */
	List<NeedExpand> queryNearbyInfos(NeedVo needVo);

}
