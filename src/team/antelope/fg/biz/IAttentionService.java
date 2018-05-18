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
	 * ��עĳ��  (����һ��Attention����)
	 * @param attention 
	 * void
	 */
	void followPerson(AttentionKey attention) throws Exception;
	/**
	 * ����ע״̬person1��person2  (��ѯһ��Attention����)
	 * ����Ѿ���ע�˾Ͳ����ٹ�ע
	 * @param attention
	 * @return
	 * @throws Exception 
	 * AttentionKey
	 */
	AttentionKey checkFollowStatus(AttentionKey attention) throws Exception;
	
}
