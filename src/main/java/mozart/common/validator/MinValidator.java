package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import mozart.common.annotation.Min;
import mozart.common.exception.MozartException;

public class MinValidator extends Validator {

	@Override
	public void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception {

		isNumber(paramName, value, request);

		Min min = (Min) annot;
		if (Double.valueOf(value) < min.min()) {
			throw new MozartException(String.format(
			    "Minimum value for parameter %s is %s",
			    paramName,
			    min.min()));
		}
	}
}
