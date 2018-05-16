package team.antelope.fg.biz;

import team.antelope.fg.pojo.Nearbymodular;

public interface INearbyService {
	/**
	 * 获取附近板块的模块信息
	 * @param type
	 * @return 
	 * NearbyModularInfo
	 */
	Nearbymodular getNearbyModularInfo(String type);
	
}
