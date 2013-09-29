package mozart.common.validator;

import java.lang.annotation.Annotation;


import mozart.common.exception.Error;
import mozart.common.exception.ErrorWrapper;

public class NotNullValidator extends Validator {

	@Override
	public void validate(ErrorWrapper wrapper, Annotation annot, String paramName, String value) throws Exception {
		if (value == null) {
			wrapper.registerError(new Error(paramName, "Can not null"));
		}
	}
}