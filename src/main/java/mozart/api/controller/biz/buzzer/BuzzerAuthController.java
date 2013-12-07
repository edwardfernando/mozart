package mozart.api.controller.biz.buzzer;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.service.BuzzerService;
import mozart.core.annotation.ExpectParam;
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
	@ExpectParam(optional = { "email", "password" })
	public Response login(@Context HttpServletRequest request) throws MozartException {
		return Response.ok(service.login(request)).build();
	}

}
