package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.SkillVo;

public interface CustomSkillMapper {
	/**
	 * ��ȡ�����ļ���Ԥ����Ϣ�б�
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedVo>
	 */
	List<SkillExpand> queryNearbyInfos(SkillVo skillVo);
	/**
	 * ����id���ϲ�ѯskill��person�����Ϣ
	 * @param id
	 * @return 
	 * SkillExpand
	 */
	SkillExpand querySkillInfoById(Long id);
}
