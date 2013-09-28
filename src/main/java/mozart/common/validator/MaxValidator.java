package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import mozart.common.annotation.Max;
import mozart.common.exception.MozartException;

public class MaxValidator extends Validator {

	@Override
	public void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception {

		isNumber(paramName, value, request);

		Max max = (Max) annot;

		if (Double.valueOf(value) > max.max()) {
			throw new MozartException(String.format(
			    "Maximum value for parameter %s is %s",
			    paramName,
			    max.max()));
		}
	}
}
