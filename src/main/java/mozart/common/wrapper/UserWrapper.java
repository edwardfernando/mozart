package mozart.common.wrapper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import mozart.api.model.User;

public class UserWrapper {
	private List<User> userList = new ArrayList<User>();
	private int count;

	public UserWrapper() {
	}

	public UserWrapper(List<User> userList) {
		this.userList = userList;
		this.count = userList.size();
	}

	public int getCount() {
		return count;
	}

	@XmlElement(name = "users-count")
	public void setCount(int count) {
		this.count = count;
	}

	public List<User> getUserList() {
		return userList;
	}

	@XmlElement(name = "user-list")
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
