package mozart.api.controller.crud;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.model.Buzzer;
import mozart.api.model.query.BuzzerQuery;
import mozart.api.service.BuzzerService;
import mozart.core.annotation.ExpectParam;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;
import mozart.core.exception.MozartException;
import mozart.core.pagination.FilterCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/buzzer")
@Produces(MediaType.APPLICATION_JSON)
public class BuzzerController extends Controller<Buzzer> {

	@Autowired
	private BuzzerService service;

	@Override
	protected ControllerConfig<Buzzer> getConfig() {
		return new ControllerConfig<Buzzer>().build(service, Buzzer.class);
	}

	@Override
	public Response loadAll(HttpServletRequest request) throws MozartException {
		GenericEntity<List<Buzzer>> ge = toGenericEntity(service.loadAll(
		    request,
		    FilterCriteria.class,
		    BuzzerQuery.class));
		return Response.ok(ge).build();
	}

	@Override
	@ExpectParam(Buzzer.class)
	public Response save(HttpServletRequest request) throws MozartException {
		service.save(request);
		return Response.ok().build();
	}
}
