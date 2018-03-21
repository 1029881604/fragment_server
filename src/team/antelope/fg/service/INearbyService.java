package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.entity.NearbyModularInfo;
import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.SkillPreInfo;

public interface INearbyService {
	/**
	 * ��ȡ����������Ԥ����Ϣ�б�
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedPreInfo>
	 */
	List<NeedPreInfo> getNearbyNeedPreInfos(String type, double latitude,
			double longitude);
	/**
	 * ��ȡ�����ļ��ܷ���Ԥ����Ϣ�б�
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<SkillPreInfo>
	 */
	List<SkillPreInfo> getNearbySkillPreInfos(String type, double latitude,
			double longitude);
	
	/**
	 * ��ȡ��������ģ����Ϣ
	 * @param type
	 * @return 
	 * NearbyModularInfo
	 */
	NearbyModularInfo getNearbyModularInfo(String type);
}
