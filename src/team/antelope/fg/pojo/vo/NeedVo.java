package team.antelope.fg.pojo.vo;

import team.antelope.fg.pojo.Need;
import team.antelope.fg.pojo.expand.NeedExpand;

/**
 * 
 * @author ���Ĳ�
 * @time:2018��5��13�� ����3:07:33
 * @Description:TODO  ������ͼ����
 */
public class NeedVo {
	/**
	 * ����ʵ����
	 */
	private Need need;
	/**
	 * ������չpojo��
	 */
	private NeedExpand needExpand;
	
	public Need getNeed() {
		return need;
	}
	public void setNeed(Need need) {
		this.need = need;
	}
	public NeedExpand getNeedExpand() {
		return needExpand;
	}
	public void setNeedExpand(NeedExpand needExpand) {
		this.needExpand = needExpand;
	}
	
}
