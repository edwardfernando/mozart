package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import mozart.common.exception.MozartException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class Validator {

	public abstract void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception;

	public void isEmpty(String paramName, String value, HttpServletRequest request)
	        throws MozartException {

		if (StringUtils.isBlank(value)) {
			throw new MozartException(String.format(
			    "Parameter %s at URI %s cannot be empty",
			    paramName,
			    request.getPathInfo()));
		}

	}

	public void isNumber(String paramName, String value, HttpServletRequest request)
	        throws MozartException {

		if (!NumberUtils.isNumber(value)) {
			throw new MozartException(String.format(
			    "Not a valid Number for parameter %s at URI %s",
			    paramName,
			    request.getPathInfo()));
		}

	}

	public void isInteger(String paramName, String value, HttpServletRequest request)
	        throws MozartException {

		if (!StringUtils.isNumeric(value)) {
			throw new MozartException(String.format(
			    "Not a valid Integer for parameter %s at URI %s",
			    paramName,
			    request.getPathInfo()));
		}

	}
}
