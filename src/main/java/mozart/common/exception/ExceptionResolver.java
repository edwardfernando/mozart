package mozart.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class ExceptionResolver implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		return Response.status(Status.BAD_REQUEST).entity(new Errors(ex.getMessage())).build();
	}

}
