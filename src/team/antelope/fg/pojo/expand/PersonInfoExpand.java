package team.antelope.fg.pojo.expand;

import java.util.Date;

import team.antelope.fg.pojo.PersonInfo;
/**
 * PersonInfo的pojo的拓展类
 * @author 华文财
 * @time:2018年5月13日 下午3:28:09
 * @Description:TODO
 */
public class PersonInfoExpand extends PersonInfo {
	//关注时间或被关注时间  业务拓展
	private Date followTime;
	public Date getFollowTime() {
		return followTime;
	}
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
}
