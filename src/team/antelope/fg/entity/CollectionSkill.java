package team.antelope.fg.entity;

import java.util.Date;

/**
 * 收藏技能表
 * @author 华文财
 * @time:2018年5月11日 下午2:15:32
 * @Description:TODO
 * id int  primary key AUTO_INCREMENT,
	user_id int not null,				--  用户id
	skill_id int not null,				--  技能id
	collect_date datetime  not null
 */
public class CollectionSkill {
	private Long id;// 收藏表id
	private Long user_id; //用户id
	private Long skill_id; //技能id
	private Date collect_date;//收藏日期
	/**
	 * 无参构造方法
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
