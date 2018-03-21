package team.antelope.fg.entity;

/**
 * 
 * @author 华文财
 * @time:2017年12月30日 上午10:57:47
 * @Description:TODO
 */

public class Person {
    private Long id; //
    private String name;    //
    private String password;    //
    private String sex;     //
    private String email;   //
    private String phonenum;   //
    private Integer age;    //
    private String headimg; //
    private Float starnum;	//
    private Integer dealnum;	//
    private Integer fansnum;   //

    public Person() {
    }

	public Person(Long id, String name, String password, String sex, String email, String phonenum, Integer age,
			String headimg, Float starnum, Integer dealnum, Integer fansnum) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.phonenum = phonenum;
		this.age = age;
		this.headimg = headimg;
		this.starnum = starnum;
		this.dealnum = dealnum;
		this.fansnum = fansnum;
	}
	public Person(String name, String password, String sex, String email, String phonenum, Integer age,
			String headimg, Float starnum, Integer dealnum, Integer fansnum) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.phonenum = phonenum;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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

	public Integer getDealnum() {
		return dealnum;
	}

	public void setDealnum(Integer dealnum) {
		this.dealnum = dealnum;
	}

	public Integer getFansnum() {
		return fansnum;
	}

	public void setFansnum(Integer fansnum) {
		this.fansnum = fansnum;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", email=" + email
				+ ", phonenum=" + phonenum + ", age=" + age + ", headimg=" + headimg + ", starnum=" + starnum
				+ ", dealnum=" + dealnum + ", fansnum=" + fansnum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((dealnum == null) ? 0 : dealnum.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fansnum == null) ? 0 : fansnum.hashCode());
		result = prime * result + ((headimg == null) ? 0 : headimg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phonenum == null) ? 0 : phonenum.hashCode());
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
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (dealnum == null) {
			if (other.dealnum != null)
				return false;
		} else if (!dealnum.equals(other.dealnum))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fansnum == null) {
			if (other.fansnum != null)
				return false;
		} else if (!fansnum.equals(other.fansnum))
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phonenum == null) {
			if (other.phonenum != null)
				return false;
		} else if (!phonenum.equals(other.phonenum))
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
