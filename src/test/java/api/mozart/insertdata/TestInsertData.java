package api.mozart.insertdata;

import mozart.api.dao.UserDAO;
import mozart.api.model.User;

import org.junit.Test;

public class TestInsertData {

	@Test
	public void testInsertUserData() {
		UserDAO userdao = new UserDAO();

		User user = new User();
		user.setId("USER-ID-1");

		userdao.save(user);
	}
}
