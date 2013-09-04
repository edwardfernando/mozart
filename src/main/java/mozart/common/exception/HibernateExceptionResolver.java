package mozart.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.hibernate.validator.method.MethodConstraintViolationException;

public class HibernateExceptionResolver implements
        ExceptionMapper<MethodConstraintViolationException> {

	@Override
	public Response toResponse(MethodConstraintViolationException ex) {

		// List<FieldError> fieldErrors =
		// ex.getBindingResult().getFieldErrors();
		// List<ObjectError> globalErrors =
		// ex.getBindingResult().getGlobalErrors();
		// List<String> errors = new ArrayList<String>(fieldErrors.size() +
		// globalErrors.size());
		// String error;
		// for (FieldError fieldError : fieldErrors) {
		// error = fieldError.getField() + ":" + fieldError.getDefaultMessage();
		// errors.add(error);
		// }
		// for (ObjectError objectError : globalErrors) {
		// error = objectError.getObjectName() + ":" +
		// objectError.getDefaultMessage();
		// errors.add(error);
		// }
		return Response
		    .status(Status.BAD_REQUEST)
		    .entity(new ErrorMessage(ex.getMessage()))
		    .build();
	}
}
