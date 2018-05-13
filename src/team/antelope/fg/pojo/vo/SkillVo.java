package team.antelope.fg.pojo.vo;

import team.antelope.fg.pojo.Skill;
import team.antelope.fg.pojo.expand.SkillExpand;

/**
 * 技能视图对象
 * @author 华文财
 * @time:2018年5月13日 下午3:15:50
 * @Description:TODO
 */
public class SkillVo {
	/**
	 * skill实体
	 */
	private Skill skill;
	/**
	 * 技能拓展pojo
	 */
	private SkillExpand skillExpand;
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public SkillExpand getSkillExpand() {
		return skillExpand;
	}
	public void setSkillExpand(SkillExpand skillExpand) {
		this.skillExpand = skillExpand;
	}
	
}
