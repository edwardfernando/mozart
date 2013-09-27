package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

public abstract class Validator {

	public abstract void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception;

}
