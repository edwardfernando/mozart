package mozart.common.validator;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import mozart.common.exception.MozartException;

public class EmailValidator extends Validator {

	private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception {

		if (!Pattern.compile(EMAIL_PATTERN).matcher(value).matches()) {
			throw new MozartException(String.format(
			    "Invalid Email format for parameter %s at URI %s",
			    paramName,
			    request.getPathInfo()));
		}
	}

}
