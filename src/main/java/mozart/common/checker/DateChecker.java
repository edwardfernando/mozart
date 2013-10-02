package mozart.common.checker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

public class DateChecker extends Checker {

	@Override
	public void check(Field field, Annotation annot) throws Throwable {
		if (!field.getType().equals(Date.class)) {
			throw new Throwable("\nAnnotation " +
			                    annot.annotationType().getCanonicalName() +
			                    " only applicable for " +
			                    Date.class.getCanonicalName() +
			                    " type");
		}
	}

}
