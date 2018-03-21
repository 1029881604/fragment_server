package team.antelope.fg.entity;
/**
 * 保证信息传输中的Person安全，不提供password、手机号等关键信息
 * 且更有针对性
 * @author 华文财
 * @time:2017年12月30日 下午4:13:23
 * @Description:TODO
 */
public class PersonInfo {
	private Long id; //
	private String name;    //
	private String sex;     //
	private String email;   //
	private int age;    //
	private String headimg; //
	private Float starnum;	//
	private int dealnum;	//
	private int fansnum;   //
	
	public PersonInfo(){};
	
	public PersonInfo(Long id, String name, String sex, String email, int age, String headimg,
			Float starnum, int dealnum, int fansnum) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.age = age;
		this.headimg = headimg;
		this.starnum = starnum;
		this.dealnum = dealnum;
		this.fansnum = fansnum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public Float getStarnum() {
		return starnum;
	}

	public void setStarnum(Float starnum) {
		this.starnum = starnum;
	}

	public int getDealnum() {
		return dealnum;
	}

	public void setDealnum(int dealnum) {
		this.dealnum = dealnum;
	}

	public int getFansnum() {
		return fansnum;
	}

	public void setFansnum(int fansnum) {
		this.fansnum = fansnum;
	}



	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", name=" + name + ", sex=" + sex + ", email=" + email + ", age=" + age + ", headimg=" + headimg + ", starnum=" + starnum + ", dealnum=" + dealnum
				+ ", fansnum=" + fansnum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + dealnum;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + fansnum;
		result = prime * result + ((headimg == null) ? 0 : headimg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((starnum == null) ? 0 : starnum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonInfo other = (PersonInfo) obj;
		if (age != other.age)
			return false;
		if (dealnum != other.dealnum)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fansnum != other.fansnum)
			return false;
		if (headimg == null) {
			if (other.headimg != null)
				return false;
		} else if (!headimg.equals(other.headimg))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (starnum == null) {
			if (other.starnum != null)
				return false;
		} else if (!starnum.equals(other.starnum))
			return false;
		return true;
	}

	
	
}
