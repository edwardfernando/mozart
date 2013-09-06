package mozart.api.service;

import mozart.api.dao.AbstractDAO;
import mozart.api.dao.UserDAO;
import mozart.api.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService extends Service<User> {

	@Autowired
	private UserDAO dao;

	@Override
	protected AbstractDAO<User> getDao() {
		return dao;
	}

}
