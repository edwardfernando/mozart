package mozart.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class MozartExceptionResolver implements ExceptionMapper<MozartException> {

	@Override
	public Response toResponse(MozartException ex) {
		return Response.status(Status.BAD_REQUEST).entity(ex.getError()).build();
	}

}
