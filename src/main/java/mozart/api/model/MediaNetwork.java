package mozart.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MediaNetwork {

	private String userId;
	private String username;
	private Date createDate;
	private List<MediaNetworkProperty> properties = new ArrayList<MediaNetworkProperty>();

	public String getUserId() {
		return userId;
	}

	@XmlElement
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	@XmlElement
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<MediaNetworkProperty> getProperties() {
		return properties;
	}

	@XmlElement
	public void setProperties(List<MediaNetworkProperty> properties) {
		this.properties = properties;
	}

}
