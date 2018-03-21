package team.antelope.fg.entity;

import java.sql.Timestamp;

/**
 * 
 * @author 华文财
 * @time:2017年12月30日 上午10:54:04
 * @Description:TODO
 */
public class PublicMessage {
	private long id;		//
	private long receiverid;	//
	private Timestamp sendtime;	//
	private String title;	//
	private String content;	//
	private boolean isread;

	/**
	 * 
	 * @para name
	 * @Description Constructor
	 */
	public PublicMessage() {
	}

	public PublicMessage(long id, long receiverid, Timestamp sendTime, String title, String content, boolean isread) {
		super();
		this.id = id;
		this.receiverid = receiverid;
		this.sendtime = sendTime;
		this.title = title;
		this.content = content;
		this.isread = isread;
	}

	public PublicMessage(long receiverid, Timestamp sendTime, String title, String content, boolean isread) {
		super();
		this.receiverid = receiverid;
		this.sendtime = sendTime;
		this.title = title;
		this.content = content;
		this.isread = isread;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getSendTime() {
		return sendtime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendtime = sendTime;
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


	public long getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(long receiverid) {
		this.receiverid = receiverid;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (receiverid ^ (receiverid >>> 32));
		result = prime * result + ((sendtime == null) ? 0 : sendtime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		PublicMessage other = (PublicMessage) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (receiverid != other.receiverid)
			return false;
		if (sendtime == null) {
			if (other.sendtime != null)
				return false;
		} else if (!sendtime.equals(other.sendtime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	public boolean isIsread() {
		return isread;
	}


	public void setIsread(boolean isread) {
		this.isread = isread;
	}


	@Override
	public String toString() {
		return "PublicMessage [id=" + id + ", receiverid=" + receiverid + ", sendtime=" + sendtime + ", title=" + title
				+ ", content=" + content + ", isread=" + isread + "]";
	}
	
	
	
}
