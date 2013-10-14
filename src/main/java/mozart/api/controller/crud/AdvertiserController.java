package mozart.api.controller.crud;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.model.Advertiser;
import mozart.api.model.query.AdvertiserQuery;
import mozart.api.service.advertiser.AdvertiserService;
import mozart.core.annotation.ExpectParam;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;
import mozart.core.exception.MozartException;
import mozart.core.pagination.FilterCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/advertiser")
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
	public Response loadAll(HttpServletRequest request) throws MozartException {
		GenericEntity<List<Advertiser>> ge = toGenericEntity(service.loadAll(
		    request,
		    FilterCriteria.class,
		    AdvertiserQuery.class));
		return Response.ok(ge).build();
	}

	@POST
	@Path("/login")
	@ExpectParam(optional = { "username", "password" })
	public Response login(@Context HttpServletRequest request) throws MozartException {
		return Response.ok(service.login(request)).build();
	}

	@Override
	protected ControllerConfig<Advertiser> getConfig() {
		return config.build(service, Advertiser.class);
	}

}