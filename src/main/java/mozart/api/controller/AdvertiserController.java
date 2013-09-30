package mozart.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.model.Advertiser;
import mozart.api.service.AdvertiserService;
import mozart.common.annotation.ExpectParam;
import mozart.common.config.ControllerConfig;
import mozart.common.exception.MozartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/advertiser")
@Produces(MediaType.APPLICATION_JSON)
public class AdvertiserController extends Controller<Advertiser> {

	@Autowired
	private AdvertiserService service;

	@Autowired
	private ControllerConfig<Advertiser> config;

	@Override
	@ExpectParam(Advertiser.class)
	public Response save(HttpServletRequest request) throws MozartException {
		service.save(request);
		return Response.ok().build();
	}

	@Override
	protected ControllerConfig<Advertiser> getConfig() {
		return config.build(service, Advertiser.class);
	}

}
