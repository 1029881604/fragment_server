package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.Nearbymodular;
import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.NeedVo;
import team.antelope.fg.pojo.vo.SkillVo;

public interface ISkillService {
	/**
	 * ��ȡ�����ļ��ܷ���Ԥ����Ϣ�б�
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<SkillPreInfo>
	 */
	List<SkillExpand> getNearbySkillPreInfos(String type, Double latitude,
			Double longitude, SkillVo skillVo);
}
