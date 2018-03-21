package team.antelope.fg.entity;

import java.sql.Timestamp;

/**
 * 
 * @author 华文财
 * @time:2017年12月30日 上午10:47:15
 * @Description:TODO
 */

public class PublishNeed {
    private long id;    //
    private long uid;   //
    private String title;   // 
    private String content; //
    private String needtype; //需求类型
    private Timestamp customdate;  //
    private Timestamp requestdate;  //
    private boolean iscomplete; //
    private boolean isonline;   //
    private String addressdesc;	//allow null 
    private Double longitude;   // allow null
    private Double latitude;   // allow null


    /**
     * 
     * @para name
     * @Description Constructor
     */
    public PublishNeed() {
    }

	public PublishNeed(long id, long uid, String title, String content, String needtype, Timestamp customdate,
			Timestamp requestdate, boolean iscomplete, boolean isonline, String addressdesc, Double longitude,
			Double latitude) {
		super();
		this.id = id;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.needtype = needtype;
		this.customdate = customdate;
		this.requestdate = requestdate;
		this.iscomplete = iscomplete;
		this.isonline = isonline;
		this.addressdesc = addressdesc;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public PublishNeed(long uid, String title, String content, String needtype, Timestamp customdate,
			Timestamp requestdate, boolean iscomplete, boolean isonline, String addressdesc, Double longitude,
			Double latitude) {
		super();
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.needtype = needtype;
		this.customdate = customdate;
		this.requestdate = requestdate;
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


	public Timestamp getCustomdate() {
		return customdate;
	}


	public void setCustomdate(Timestamp customdate) {
		this.customdate = customdate;
	}


	public Timestamp getRequestdate() {
		return requestdate;
	}


	public void setRequestdate(Timestamp requestdate) {
		this.requestdate = requestdate;
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

	public String getNeedtype() {
		return needtype;
	}

	public void setNeedtype(String needtype) {
		this.needtype = needtype;
	}

	@Override
	public String toString() {
		return "PublishNeed [id=" + id + ", uid=" + uid + ", title=" + title + ", content=" + content + ", needtype="
				+ needtype + ", customdate=" + customdate + ", requestdate=" + requestdate + ", iscomplete="
				+ iscomplete + ", isonline=" + isonline + ", addressdesc=" + addressdesc + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressdesc == null) ? 0 : addressdesc.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((customdate == null) ? 0 : customdate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (iscomplete ? 1231 : 1237);
		result = prime * result + (isonline ? 1231 : 1237);
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((needtype == null) ? 0 : needtype.hashCode());
		result = prime * result + ((requestdate == null) ? 0 : requestdate.hashCode());
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
		PublishNeed other = (PublishNeed) obj;
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
		if (customdate == null) {
			if (other.customdate != null)
				return false;
		} else if (!customdate.equals(other.customdate))
			return false;
		if (id != other.id)
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
		if (needtype == null) {
			if (other.needtype != null)
				return false;
		} else if (!needtype.equals(other.needtype))
			return false;
		if (requestdate == null) {
			if (other.requestdate != null)
				return false;
		} else if (!requestdate.equals(other.requestdate))
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
