package team.antelope.fg.biz;

import team.antelope.fg.pojo.AttentionKey;

/**
 * ��ע����ӿ�
 * @author ���Ĳ�
 * @time:2018��5��18�� ����4:27:39
 * @Description:TODO
 */
public interface IAttentionService {
	/**
	 * ��עĳ��
	 * @param attention 
	 * void
	 */
	void followPerson(AttentionKey attention) throws Exception;
	
	AttentionKey checkFollowStatus(AttentionKey attention) throws Exception;
}
