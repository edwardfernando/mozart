package mozart.api.service.advertiser;

import mozart.api.dao.UserDAO;
import mozart.api.model.User;
import mozart.api.service.Service;
import mozart.core.db.AbstractDAO;

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

	@Override
	protected Class<User> getModel() {
		return User.class;
	}

}
