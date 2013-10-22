package mozart.api.controller.crud;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.model.BankAccount;
import mozart.api.service.BankAccountService;
import mozart.core.annotation.ExpectParam;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;
import mozart.core.exception.MozartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/bank/account")
@Produces(MediaType.APPLICATION_JSON)
public class BankAccountController extends Controller<BankAccount> {

	@Autowired
	private BankAccountService service;

	@Autowired
	private ControllerConfig<BankAccount> config;

	@Override
	protected ControllerConfig<BankAccount> getConfig() {
		return config.build(service, BankAccount.class);
	}

	@Override
	@ExpectParam(BankAccount.class)
	public Response save(HttpServletRequest request) throws MozartException {
		service.save(request);
		return Response.ok().build();
	}
}
