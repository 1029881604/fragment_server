package team.antelope.fg.constant;
/**
 * ���ݿ����Ҫ�õĳ���
 * @author ���Ĳ�
 * @time:2018��5��17�� ����9:05:10
 * @Description:TODO
 */
public interface DBConst {
	//comment
	/**
	 * ���۱�comment��topicType����
	 *   '1Ϊuser��2Ϊskill��3Ϊneed'   ���ݴ����͹������Ϊuser��Ϊskill/need������û�����
	 */
	Short COMMENT_TOPICTYPE_USER = 1;
	Short COMMENT_TOPICTYPE_Skill = 2;
	Short COMMENT_TOPICTYPE_NEED = 3;
	/**
	 * ���۱�comment������״̬����
	 * '����״̬��-1Ϊɾ����0Ϊ����ˣ�1Ϊ�ѷ���'
	 */
	Short COMMENT_STATUS_DEL = -1;
	Short COMMENT_STATUS_CHECK = 0;
	Short COMMENT_STATUS_PUBLISH = 1;
	
	//comment_reply
	
	
}
