package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import mozart.common.exception.MozartException;

public class NumberOnlyValidator extends Validator {

	@Override
	public void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception {
		for (int i = 0; i < value.length(); i++) {
			if (!".,0123456789".contains(String.valueOf(value.charAt(i)))) {
				throw new MozartException(String.format(
				    "Not a valid numer for parameter %s at URI %s",
				    paramName,
				    request.getPathInfo()));
			}
		}
	}

}
