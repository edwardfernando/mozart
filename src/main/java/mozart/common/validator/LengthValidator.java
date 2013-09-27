package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import mozart.common.annotation.Length;
import mozart.common.exception.MozartException;

public class LengthValidator extends Validator {

	@Override
	public void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception {
		Length length = (Length) annot;
		int valueLength = value.length();

		if (valueLength < length.minLength() || valueLength > length.maxLength()) {
			throw new MozartException(String.format(
			    "Length parameter %s at URI %s should be between %s and %s characters",
			    paramName,
			    request.getPathInfo(),
			    length.minLength(),
			    length.maxLength()));
		}

	}
}
