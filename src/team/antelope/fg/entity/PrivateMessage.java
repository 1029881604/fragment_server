package team.antelope.fg.entity;

import java.sql.Timestamp;

/**
 * 
 * @author 华文财
 * @time:2017年12月30日 上午10:50:43
 * @Description:TODO
 */
public class PrivateMessage {
	private long id;		//
	private long senderid;	//
	private String sendername;//
	private long receiverid;//
	private String receivername;//
	private Timestamp sendtime;		//
	private String content;	//
	private boolean isread;	//

	/**
	 * 
	 * @para name
	 * @Description Constructor
	 */
	public PrivateMessage() {
	}

	public PrivateMessage(long id, long senderid, String sendername, long receiverid, String receivername,
			Timestamp sendtime, String content, boolean isread) {
		super();
		this.id = id;
		this.senderid = senderid;
		this.sendername = sendername;
		this.receiverid = receiverid;
		this.receivername = receivername;
		this.sendtime = sendtime;
		this.content = content;
		this.isread = isread;
	}

	public PrivateMessage(long senderid, String sendername, long receiverid, String receivername,
			Timestamp sendtime, String content, boolean isread) {
		super();
		this.senderid = senderid;
		this.sendername = sendername;
		this.receiverid = receiverid;
		this.receivername = receivername;
		this.sendtime = sendtime;
		this.content = content;
		this.isread = isread;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSenderid() {
		return senderid;
	}

	public void setSenderid(long senderid) {
		this.senderid = senderid;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public long getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(long receiverid) {
		this.receiverid = receiverid;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public Timestamp getSendtime() {
		return sendtime;
	}

	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isIsread() {
		return isread;
	}

	public void setIsread(boolean isread) {
		this.isread = isread;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isread ? 1231 : 1237);
		result = prime * result + (int) (receiverid ^ (receiverid >>> 32));
		result = prime * result + ((receivername == null) ? 0 : receivername.hashCode());
		result = prime * result + (int) (senderid ^ (senderid >>> 32));
		result = prime * result + ((sendername == null) ? 0 : sendername.hashCode());
		result = prime * result + ((sendtime == null) ? 0 : sendtime.hashCode());
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
		PrivateMessage other = (PrivateMessage) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (isread != other.isread)
			return false;
		if (receiverid != other.receiverid)
			return false;
		if (receivername == null) {
			if (other.receivername != null)
				return false;
		} else if (!receivername.equals(other.receivername))
			return false;
		if (senderid != other.senderid)
			return false;
		if (sendername == null) {
			if (other.sendername != null)
				return false;
		} else if (!sendername.equals(other.sendername))
			return false;
		if (sendtime == null) {
			if (other.sendtime != null)
				return false;
		} else if (!sendtime.equals(other.sendtime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrivateMessage [id=" + id + ", senderid=" + senderid + ", sendername=" + sendername + ", receiverid="
				+ receiverid + ", receivername=" + receivername + ", sendtime=" + sendtime + ", content=" + content
				+ ", isread=" + isread + "]";
	}
	
	
}
