package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.pojo.Nearbymodular;
import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.expand.SkillExpand;
import team.antelope.fg.pojo.vo.NeedVo;
import team.antelope.fg.pojo.vo.PersonInfoVo;
import team.antelope.fg.pojo.vo.SkillVo;

public interface ISNearbyService {
	/**
	 * ��ȡ����������Ԥ����Ϣ�б�
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedPreInfo>
	 */
	List<NeedExpand> getNearbyNeedPreInfos(String type, Double latitude,
			Double longitude, NeedVo needVo);
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
	/**
	 * ��ȡ��������ģ����Ϣ
	 * @param type
	 * @return 
	 * NearbyModularInfo
	 */
	Nearbymodular getNearbyModularInfo(String type);
	/**
	 * ͨ��id���Ҹ�����Ϣ
	 * @param id
	 * @return 
	 * PersonInfo
	 */
	PersonInfo getPersonInfo(Long id);
	
}
