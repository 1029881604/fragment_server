package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.expand.SkillExpand;
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
			Double longitude, SkillVo skillVo) throws Exception;
	/**
	 * ��ȡ������Ϣ֮ǰҪ����ͼ��ܷ���ʱ�ľ���
	 * ��ҵ���߼�
	 * @param id
	 * @return   ���ܱ��������һ��img�ֶ�
	 * SkillExpand
	 */
	SkillExpand getSkillInfoById(Long id, Double latitude, Double longitude) throws Exception;
}
