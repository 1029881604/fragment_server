package team.antelope.fg.entity;

public class Attention {  //¶ÔÓ¦attention±í
	private long uid;
	private long attentionuserid;
	
	public Attention(){
	}

	
	public Attention(long uid, long attentionuserid) {
		super();
		this.uid = uid;
		this.attentionuserid = attentionuserid;
	}

	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (attentionuserid ^ (attentionuserid >>> 32));
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
		Attention other = (Attention) obj;
		if (attentionuserid != other.attentionuserid)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attention [uid=" + uid + ", attentionuserid=" + attentionuserid + "]";
	}


	public long getAttentionuserid() {
		return attentionuserid;
	}


	public void setAttentionuserid(long attentionuserid) {
		this.attentionuserid = attentionuserid;
	}
}


