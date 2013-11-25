package mozart.api.controller.biz.buzzer;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.service.BuzzerService;
import mozart.core.exception.MozartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/b/buzzer")
@Produces(MediaType.APPLICATION_JSON)
public class BuzzerAuthController {

	@Autowired
	private BuzzerService service;

	@POST
	@Path("/login")
	public Response login(@FormParam("username") String email,
	        @FormParam("password") String password) throws MozartException {

		return Response.ok(email + " ~ " + password).build();
	}

}
