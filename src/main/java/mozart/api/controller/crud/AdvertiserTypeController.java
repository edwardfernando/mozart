package mozart.api.controller.crud;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.service.AdvertiserTypeService;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;
import mozart.core.datasource.pojo.AdvertiserType;
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
	@GET
	@Path("/{id}")
	public Response loadById(@PathParam("id") String id, @Context HttpServletRequest request)
	        throws MozartException {
		return Response.ok(service.loadById(id)).build();
	}

	@Override
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String id, @Context HttpServletRequest request)
	        throws MozartException {
		throw new MozartException("Unrecognized DELETE action for " + request.getPathInfo());
	}
}
