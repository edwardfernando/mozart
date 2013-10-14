package mozart.api.controller.crud;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.model.Message;
import mozart.api.service.advertiser.MessageService;
import mozart.api.wrapper.MessageWrapper;
import mozart.core.annotation.ExpectParam;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;
import mozart.core.exception.MozartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageController extends Controller<Message> {

	@Autowired
	private MessageService service;

	@Autowired
	private ControllerConfig<Message> config;

	@Override
	public Response loadAll(HttpServletRequest request) throws MozartException {
		return Response.ok(new MessageWrapper(service.loadAll())).build();
	}

	@Override
	@ExpectParam(Message.class)
	public Response save(HttpServletRequest request) throws MozartException {
		service.save(request);
		return Response.ok().build();
	}

	@Override
	protected ControllerConfig<Message> getConfig() {
		return config.build(service, Message.class);
	}

}
