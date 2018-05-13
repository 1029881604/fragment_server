package team.antelope.fg.pojo.expand;

import team.antelope.fg.pojo.Skill;

/**
 * 技能拓展pojo类
 * @author 华文财
 * @time:2018年5月13日 下午3:13:51
 * @Description:TODO
 */
public class SkillExpand extends Skill {

	private String usreName;
	private String headimg;
	public String getUsreName() {
		return usreName;
	}
	public void setUsreName(String usreName) {
		this.usreName = usreName;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
}
