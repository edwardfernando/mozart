package mozart.common.validator;

import java.lang.annotation.Annotation;

import mozart.common.annotation.Date;
import mozart.common.exception.Error;
import mozart.common.exception.ErrorWrapper;

import org.joda.time.format.DateTimeFormat;

public class DateValidator extends Validator {

	@Override
	public void validate(ErrorWrapper errorWrapper, Annotation annot, String paramName, String value)
	        throws Exception {
		Date date = (Date) annot;
		String format = date.format();

		try {
			DateTimeFormat.forPattern(format).parseDateTime(value);
		} catch (Exception e) {
			errorWrapper
			    .registerError(new Error(paramName, String.format("Invalid date.", format)));
		}
	}
}
