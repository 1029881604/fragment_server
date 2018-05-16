package team.antelope.fg.pojo.expand;

import team.antelope.fg.pojo.Need;
/**
 * 需求拓展bean
 * @author 华文财
 * @time:2018年5月13日 下午3:07:49
 * @Description:TODO
 */
public class NeedExpand extends Need {
	
	//biz add  
	private Double distance;
	//vo add
	private String userName;
	private String headimg;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
}
