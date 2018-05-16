package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.vo.NeedVo;
/**
 * Nearby模块需求业务类
 * @author 华文财
 * @time:2018年5月14日 上午10:49:06
 * @Description:TODO
 */
public interface INeedService {
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
	 * 获取需求信息之前要计算和需求发布时的距离
	 * 有业务逻辑
	 * @param id
	 * @return 
	 * NeedExpand
	 */
	NeedExpand getNeedInfoById(Long id, Double latitude, Double longitude);
}
