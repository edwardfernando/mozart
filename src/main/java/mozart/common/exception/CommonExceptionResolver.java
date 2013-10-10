package mozart.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class CommonExceptionResolver implements ExceptionMapper<Throwable> {

	private final ErrorWrapper error = new ErrorWrapper();

	@Override
	public Response toResponse(Throwable ex) {
		error.registerError(new Error(String.format(
		    "Unknown Exception Caught : %s",
		    ex.getMessage())));

		return Response.status(Status.BAD_REQUEST).entity(error.getErrors()).build();
	}

}
