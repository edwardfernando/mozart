package mozart.common.validator;

import java.lang.annotation.Annotation;


import mozart.common.exception.ErrorWrapper;

public class NumberOnlyValidator extends Validator {

	@Override
	public void validate(ErrorWrapper wrapper, Annotation annot, String paramName, String value) throws Exception {
		isNumber(wrapper, paramName, value);
	}

}
