package team.antelope.fg.pojo.expand;

import java.util.Date;

import team.antelope.fg.pojo.PersonInfo;
/**
 * PersonInfo��pojo����չ��
 * @author ���Ĳ�
 * @time:2018��5��13�� ����3:28:09
 * @Description:TODO
 */
public class PersonInfoExpand extends PersonInfo {
	//��עʱ��򱻹�עʱ��  ҵ����չ
	private Date followTime;
	public Date getFollowTime() {
		return followTime;
	}
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
}
