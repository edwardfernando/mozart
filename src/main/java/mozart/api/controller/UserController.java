package mozart.api.controller;

import java.lang.reflect.Type;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mozart.api.model.User;
import mozart.api.service.Service;
import mozart.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserController extends BaseController<User> {

	@Autowired
	private UserService service;

	@Override
	protected Service<User> getService() {
		return service;
	}

	@Override
	protected Type getType() {
		return User.class;
	}

}
