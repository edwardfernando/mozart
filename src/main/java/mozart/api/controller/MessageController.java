package mozart.api.controller;

import java.lang.reflect.Type;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mozart.api.model.Message;
import mozart.api.service.MessageService;
import mozart.api.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageController extends BaseController<Message> {

	@Autowired
	private MessageService service;

	@Override
	protected Service<Message> getService() {
		return service;
	}

	@Override
	protected Type getType() {
		return Message.class;
	}

}
