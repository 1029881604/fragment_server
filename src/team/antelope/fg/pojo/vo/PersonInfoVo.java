package team.antelope.fg.pojo.vo;

import java.util.Date;

import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.PersonInfoExpand;

/**
 * PersonInfo�İ�װ��
 * @author ���Ĳ�
 * @time:2018��5��13�� ����3:28:37
 * @Description:TODO
 */
public class PersonInfoVo {
	//�û���Ϣ��չ
	private PersonInfoExpand personInfoExpand;
	//�û���Ϣ
	private PersonInfo personInfo;
	
	//��עʱ��򱻹�עʱ��  ҵ����չ
	private Date followTime;
	
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	public PersonInfoExpand getPersonInfoExpand() {
		return personInfoExpand;
	}
	public void setPersonInfoExpand(PersonInfoExpand personInfoExpand) {
		this.personInfoExpand = personInfoExpand;
	}
	public Date getFollowTime() {
		return followTime;
	}
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
}
