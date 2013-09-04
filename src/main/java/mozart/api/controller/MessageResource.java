package mozart.api.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.model.Message;
import mozart.api.service.MessageService;

import org.jboss.resteasy.spi.validation.ValidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	@Autowired
	private MessageService service;

	@Path("")
	@GET
	public List<Message> getMessageList() {
		return service.loadAll();
	}

	@Path("")
	@POST
	public void post(Message m) {
		System.out.println("saving.....");
	}

	@Path("/{id}")
	@GET
	@ValidateRequest
	public Response getMessageById(@PathParam("id") String id) throws Exception {
		Message m = service.loadById(id);

		if (m == null) {
			throw new Exception("Not Found");
		}

		return Response.ok(m).build();
	}
}
