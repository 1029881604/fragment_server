package team.antelope.fg.entity;

import java.util.Date;

/**
 * �ղؼ��ܱ�
 * @author ���Ĳ�
 * @time:2018��5��11�� ����2:15:32
 * @Description:TODO
 * id int  primary key AUTO_INCREMENT,
	user_id int not null,				--  �û�id
	skill_id int not null,				--  ����id
	collect_date datetime  not null
 */
public class CollectionSkill {
	private Long id;// �ղر�id
	private Long user_id; //�û�id
	private Long skill_id; //����id
	private Date collect_date;//�ղ�����
	/**
	 * �޲ι��췽��
	 */
	public CollectionSkill() {
	}
	
	public CollectionSkill(Long user_id, Long skill_id, Date collect_date) {
		super();
		this.user_id = user_id;
		this.skill_id = skill_id;
		this.collect_date = collect_date;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(Long skill_id) {
		this.skill_id = skill_id;
	}
	public Date getCollect_date() {
		return collect_date;
	}
	public void setCollect_date(Date collect_date) {
		this.collect_date = collect_date;
	}
	@Override
	public String toString() {
		return "CollectionSkill [id=" + id + ", user_id=" + user_id + ", skill_id=" + skill_id + ", collect_date="
				+ collect_date + "]";
	}
	
}
