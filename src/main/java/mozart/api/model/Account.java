package mozart.api.model;

import java.util.Date;

public class Account {
	private String id;
	private MediaNetwork mediaNetwork;
	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MediaNetwork getMediaNetwork() {
		return mediaNetwork;
	}

	public void setMediaNetwork(MediaNetwork mediaNetwork) {
		this.mediaNetwork = mediaNetwork;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
