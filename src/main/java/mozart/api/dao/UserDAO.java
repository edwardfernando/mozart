package mozart.api.dao;

import mozart.api.model.User;
import mozart.core.db.AbstractDAO;

import org.springframework.stereotype.Component;

@Component
public class UserDAO extends AbstractDAO<User> {

	@Override
	public Class<User> getModel() {
		return User.class;
	}

}
