package mozart.common.validator;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

public class NotEmptyValidator extends Validator {

	@Override
	public void validate(Annotation annot, String paramName, String value,
	        HttpServletRequest request) throws Exception {
		isEmpty(paramName, value, request);
	}
}
