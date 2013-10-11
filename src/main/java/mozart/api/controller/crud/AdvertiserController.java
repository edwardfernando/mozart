package mozart.api.controller.crud;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.controller.Controller;
import mozart.api.model.Advertiser;
import mozart.api.model.query.AdvertiserQuery;
import mozart.api.service.advertiser.AdvertiserService;
import mozart.common.annotation.ExpectParam;
import mozart.common.config.ControllerConfig;
import mozart.common.exception.MozartException;
import mozart.common.pagination.FilterCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/crud/advertiser")
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
		return Response
		    .ok(
		        toGenericEntity(service.loadAll(
		            request,
		            FilterCriteria.class,
		            AdvertiserQuery.class))).build();
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