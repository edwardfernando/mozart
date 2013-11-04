package mozart.api.controller.crud;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.model.BankAccount;
import mozart.api.model.query.BankAccountQuery;
import mozart.api.service.BankAccountService;
import mozart.core.annotation.ExpectParam;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;
import mozart.core.exception.MozartException;
import mozart.core.pagination.FilterCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/bank/account")
@Produces(MediaType.APPLICATION_JSON)
public class BankAccountController extends Controller<BankAccount> {

	@Autowired
	private BankAccountService service;

	@Override
	protected ControllerConfig<BankAccount> getConfig() {
		return new ControllerConfig<BankAccount>().build(service, BankAccount.class);
	}

	@Override
	public Response loadAll(HttpServletRequest request) throws MozartException {
		GenericEntity<List<BankAccount>> ge = toGenericEntity(service.loadAll(
		    request,
		    FilterCriteria.class,
		    BankAccountQuery.class));
		return Response.ok(ge).build();
	}

	@Override
	@ExpectParam(BankAccount.class)
	public Response save(HttpServletRequest request) throws MozartException {
		service.save(request);
		return Response.ok().build();
	}
}
