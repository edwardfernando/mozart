package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import mozart.common.exception.MozartException;

public class NotEmptyValidator extends Validator {

	@Override
	public void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception {
		if (value.isEmpty()) {
			throw new MozartException(String.format(
			    "Parameter %s at URI %s cannot be empty",
			    paramName,
			    request.getPathInfo()));
		}
	}
}
