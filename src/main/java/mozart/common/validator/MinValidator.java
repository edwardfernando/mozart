package mozart.common.validator;

import java.lang.annotation.Annotation;


import mozart.common.annotation.Min;
import mozart.common.exception.Error;
import mozart.common.exception.ErrorWrapper;

public class MinValidator extends Validator {

	@Override
	public void validate(ErrorWrapper wrapper, Annotation annot, String paramName, String value) throws Exception {

		if (isNumber(wrapper, paramName, value)) {
			Min min = (Min) annot;
			if (Double.valueOf(value) < min.min()) {
				wrapper.registerError(new Error(paramName, String.format(
				    "Minimum value for parameter %s is %s",
				    paramName,
				    min.min())));
			}
		}
	}
}
