package mozart.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionResolver {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorMessage handleException(Exception ex) {
		return new ErrorMessage(ex.getMessage());
	}

	/*
	 * @ExceptionHandler
	 * 
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ResponseBody public ErrorMessage
	 * handleException(MethodArgumentNotValidException ex) { List<FieldError>
	 * fieldErrors = ex.getBindingResult().getFieldErrors(); List<ObjectError>
	 * globalErrors = ex.getBindingResult().getGlobalErrors(); List<String>
	 * errors = new ArrayList<String>(fieldErrors.size() + globalErrors.size());
	 * String error; for (FieldError fieldError : fieldErrors) { error =
	 * fieldError.getField() + ":" + fieldError.getDefaultMessage();
	 * errors.add(error); } for (ObjectError objectError : globalErrors) { error
	 * = objectError.getObjectName() + ":" + objectError.getDefaultMessage();
	 * errors.add(error); } return new ErrorMessage(errors); }
	 */
}
