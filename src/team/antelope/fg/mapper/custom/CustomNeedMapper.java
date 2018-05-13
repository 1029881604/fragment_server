package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.vo.NeedVo;

public interface CustomNeedMapper {
	/**
	 * ��ȡ����������Ԥ����Ϣ�б�
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedVo>
	 */
	List<NeedExpand> queryNearbyInfos(NeedVo needVo);

}
