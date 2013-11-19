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

import mozart.api.service.CountryService;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;
import mozart.core.datasource.pojo.Country;
import mozart.core.exception.MozartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/country")
@Produces(MediaType.APPLICATION_JSON)
public class CountryController extends Controller<Country> {

	@Autowired
	private CountryService service;

	@Override
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String id, @Context HttpServletRequest request)
	        throws MozartException {
		throw new MozartException("Unrecognized DELETE action for " + request.getPathInfo());
	}

	@Override
	@GET
	@Path("/{id}")
	public Response loadById(@PathParam("id") String id, @Context HttpServletRequest request)
	        throws MozartException {
		return Response.ok(service.loadById(id)).build();
	}

	@Override
	protected ControllerConfig<Country> getConfig() {
		return new ControllerConfig<Country>().build(service, Country.class);
	}

}
