package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import mozart.common.annotation.Pattern;
import mozart.common.exception.MozartException;

public class PatternValidator extends Validator {

	@Override
	public void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception {
		Pattern pattern = (Pattern) annot;

		boolean result = java.util.regex.Pattern
		    .compile(pattern.pattern())
		    .matcher(value)
		    .matches();

		if (!result) {
			throw new MozartException(String.format(
			    "Parameter %s at URI %s is not match with specified patter (%)",
			    paramName,
			    request.getPathInfo(),
			    pattern.pattern()));
		}
	}
}
