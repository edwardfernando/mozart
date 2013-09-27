package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import mozart.common.exception.MozartException;

public class NotNullValidator extends Validator {

	@Override
	public void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception {
		if (value == null) {
			throw new MozartException(String.format(
			    "Parameter %s at URI %s cannot be null",
			    paramName,
			    request.getPathInfo()));
		}
	}
}