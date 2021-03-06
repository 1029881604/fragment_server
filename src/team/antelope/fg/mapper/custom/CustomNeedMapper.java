package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.vo.NeedVo;
/**
 * 附近模块需求数据访问层
 * @author 华文财
 * @time:2018年5月14日 上午10:49:52
 * @Description:TODO
 */
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
	
	/**
	 * 根据需求的id联合查询need和person相关信息
	 * @param id
	 * @return 
	 * NeedExpand
	 */
	NeedExpand queryNeedInfoById(Long id);
	/**
	 * 根据用户的id单表查询need
	 * 可能还有业务条件， 比如时间之类的，是否完成
	 * @param id
	 * @return 
	 * NeedExpand
	 */
	List<NeedExpand> queryNeedInfosByPerson(NeedVo needVo);
}
