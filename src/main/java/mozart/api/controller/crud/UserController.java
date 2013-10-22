package mozart.api.controller.crud;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mozart.api.model.User;
import mozart.api.service.UserService;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserController extends Controller<User> {

	@Autowired
	private UserService service;

	@Autowired
	private ControllerConfig<User> config;

	@Override
	protected ControllerConfig<User> getConfig() {
		return config.build(service, User.class);
	}

}