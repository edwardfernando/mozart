package mozart.api.controller.crud;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.model.AdvertiserType;
import mozart.api.service.AdvertiserTypeService;
import mozart.core.annotation.ExpectParam;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;
import mozart.core.exception.MozartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/advertiser/type")
@Produces(MediaType.APPLICATION_JSON)
public class AdvertiserTypeController extends Controller<AdvertiserType> {

	@Autowired
	private AdvertiserTypeService service;

	@Override
	protected ControllerConfig<AdvertiserType> getConfig() {
		return new ControllerConfig<AdvertiserType>().build(service, AdvertiserType.class);
	}

	@Override
	@ExpectParam(AdvertiserType.class)
	public Response save(HttpServletRequest request) throws MozartException {
		service.save(request);
		return Response.ok().build();
	}
}
