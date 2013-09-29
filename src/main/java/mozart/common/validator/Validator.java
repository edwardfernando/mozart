package mozart.common.validator;

import java.lang.annotation.Annotation;


import mozart.common.exception.Error;
import mozart.common.exception.ErrorWrapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class Validator {

	public abstract void validate(ErrorWrapper errorWrapper, Annotation annot, String paramName,
	        String value) throws Exception;

	public boolean isEmpty(ErrorWrapper errorWrapper, String paramName, String value) {
		boolean result = true;

		if (StringUtils.isBlank(value)) {
			errorWrapper.registerError(new Error(paramName, "Should not empty string"));
			result = false;
		}

		return result;
	}

	public boolean isNumber(ErrorWrapper errorWrapper, String paramName, String value) {
		boolean result = true;

		if (!NumberUtils.isNumber(value)) {
			errorWrapper.registerError(new Error(paramName, "Not a numeric value"));
			result = false;
		}

		return result;
	}

	public boolean isInteger(ErrorWrapper errorWrapper, String paramName, String value) {
		boolean result = true;

		if (!StringUtils.isNumeric(value)) {
			errorWrapper.registerError(new Error(paramName, "Not an integer value"));
			result = false;
		}

		return result;
	}

	public boolean isEmpty(String value) {
		return StringUtils.isBlank(value);
	}

	public boolean isNumber(String value) {
		return NumberUtils.isNumber(value);
	}

	public boolean isInteger(String value) {
		return StringUtils.isNumeric(value);
	}

}
