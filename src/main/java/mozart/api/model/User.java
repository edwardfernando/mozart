package mozart.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String id;
	private String username;
	private String password;
	private List<Badge> badges = new ArrayList<Badge>();

	public String getUsername() {
		return username;
	}

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	@XmlElement
	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

}
