package team.antelope.fg.pojo.expand;

import team.antelope.fg.pojo.Skill;

/**
 * ������չpojo��
 * @author ���Ĳ�
 * @time:2018��5��13�� ����3:13:51
 * @Description:TODO
 */
public class SkillExpand extends Skill {
	//biz add  
	private Double distance;
	
	private String userName;
	private String headimg;
	
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
