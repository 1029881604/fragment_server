package team.antelope.fg.biz;

import team.antelope.fg.pojo.Nearbymodular;

public interface INearbyService {
	/**
	 * ��ȡ��������ģ����Ϣ
	 * @param type
	 * @return 
	 * NearbyModularInfo
	 */
	Nearbymodular getNearbyModularInfo(String type);
	
}
