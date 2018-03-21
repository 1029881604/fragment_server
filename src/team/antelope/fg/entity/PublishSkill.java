package team.antelope.fg.entity;

import java.sql.Timestamp;

/**
 * 
 * @author 华文财
 * @time:2017年12月30日 上午10:43:08
 * @Description:TODO
 */

public class PublishSkill {
    private long id;
    private long uid;
    private String title; 
    private String content; 
    private Timestamp publishdate;
    private Timestamp stopdate;
    private String img; 
    private String  skilltype;
    private boolean iscomplete;
    private boolean isonline;   
    private String addressdesc;	// allow null 
    private Double longitude;	// allow null
	private Double latitude;	// allow null
    /**
     * @para name
     * @Description Constructor
     */

    public PublishSkill() {
    }
    
	public PublishSkill(long uid, String title, String content, Timestamp publishdate, Timestamp stopdate, String img,
			String skilltype, boolean iscomplete, boolean isonline, String addressdesc, Double longitude,
			Double latitude) {
		super();
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.publishdate = publishdate;
		this.stopdate = stopdate;
		this.img = img;
		this.skilltype = skilltype;
		this.iscomplete = iscomplete;
		this.isonline = isonline;
		this.addressdesc = addressdesc;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public PublishSkill(long id, long uid, String title, String content, Timestamp publishdate, Timestamp stopdate, String img,
			String skilltype, boolean iscomplete, boolean isonline, String addressdesc, Double longitude,
			Double latitude) {
		super();
		this.id = id;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.publishdate = publishdate;
		this.stopdate = stopdate;
		this.img = img;
		this.skilltype = skilltype;
		this.iscomplete = iscomplete;
		this.isonline = isonline;
		this.addressdesc = addressdesc;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public Timestamp getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Timestamp publishdate) {
		this.publishdate = publishdate;
	}
	public Timestamp getStopdate() {
		return stopdate;
	}
	public void setStopdate(Timestamp stopdate) {
		this.stopdate = stopdate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSkilltype() {
		return skilltype;
	}
	public void setSkilltype(String skilltype) {
		this.skilltype = skilltype;
	}
	public boolean isIscomplete() {
		return iscomplete;
	}
	public void setIscomplete(boolean iscomplete) {
		this.iscomplete = iscomplete;
	}
	public boolean isIsonline() {
		return isonline;
	}
	public void setIsonline(boolean isonline) {
		this.isonline = isonline;
	}
	public String getAddressdesc() {
		return addressdesc;
	}
	public void setAddressdesc(String addressdesc) {
		this.addressdesc = addressdesc;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "PublishSkill [id=" + id + ", uid=" + uid + ", publishdate=" + publishdate + ", stopdate=" + stopdate
				+ ", img=" + img + ", title=" + title + ", content=" + content + ", skilltype=" + skilltype
				+ ", iscomplete=" + iscomplete + ", isonline=" + isonline + ", addressdesc=" + addressdesc
				+ ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressdesc == null) ? 0 : addressdesc.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + (iscomplete ? 1231 : 1237);
		result = prime * result + (isonline ? 1231 : 1237);
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((publishdate == null) ? 0 : publishdate.hashCode());
		result = prime * result + ((skilltype == null) ? 0 : skilltype.hashCode());
		result = prime * result + ((stopdate == null) ? 0 : stopdate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + (int) (uid ^ (uid >>> 32));
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
		PublishSkill other = (PublishSkill) obj;
		if (addressdesc == null) {
			if (other.addressdesc != null)
				return false;
		} else if (!addressdesc.equals(other.addressdesc))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (iscomplete != other.iscomplete)
			return false;
		if (isonline != other.isonline)
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (publishdate == null) {
			if (other.publishdate != null)
				return false;
		} else if (!publishdate.equals(other.publishdate))
			return false;
		if (skilltype == null) {
			if (other.skilltype != null)
				return false;
		} else if (!skilltype.equals(other.skilltype))
			return false;
		if (stopdate == null) {
			if (other.stopdate != null)
				return false;
		} else if (!stopdate.equals(other.stopdate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

}
