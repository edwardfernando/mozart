package mozart.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String id;
	private List<Account> accounts = new ArrayList<Account>();
	private List<Badge> badges = new ArrayList<Badge>();

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	@XmlElement
	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	@XmlElement
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
