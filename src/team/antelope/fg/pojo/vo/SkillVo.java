package team.antelope.fg.pojo.vo;

import team.antelope.fg.pojo.Skill;
import team.antelope.fg.pojo.expand.SkillExpand;

/**
 * ������ͼ����
 * @author ���Ĳ�
 * @time:2018��5��13�� ����3:15:50
 * @Description:TODO
 */
public class SkillVo {
	/**
	 * skillʵ��
	 */
	private Skill skill;
	/**
	 * ������չpojo
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
