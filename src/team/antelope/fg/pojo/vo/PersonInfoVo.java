package team.antelope.fg.pojo.vo;

import java.util.Date;

import team.antelope.fg.pojo.PersonInfo;
import team.antelope.fg.pojo.expand.PersonInfoExpand;

/**
 * PersonInfo的包装类
 * @author 华文财
 * @time:2018年5月13日 下午3:28:37
 * @Description:TODO
 */
public class PersonInfoVo {
	//用户信息拓展
	private PersonInfoExpand personInfoExpand;
	//用户信息
	private PersonInfo personInfo;
	
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
}
