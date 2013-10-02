package mozart.common.validator;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

import mozart.common.exception.Error;
import mozart.common.exception.ErrorWrapper;

public class EmailValidator extends Validator {

	private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public void validate(ErrorWrapper errorWrapper, Annotation annot, String paramName, String value)
	        throws Exception {

		if (!Pattern.compile(EMAIL_PATTERN).matcher(value).matches()) {
			errorWrapper.registerError(new Error(paramName, "Not a valid email format"));
		}

	}

}
