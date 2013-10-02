package mozart.common.checker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class Checker {
	private final String exceptionMessage = "\n[Source: %s][Field/Type: %s/%s] : Annotation %s only applicable for %s";

	public void check(Class<?> source, Field field, Annotation annot) throws Throwable {

		for (Class<?> expected : expectedType()) {
			if (!field.getType().equals(expected)) {
				throw new Throwable(String.format(
				    exceptionMessage,
				    source.getCanonicalName(),
				    field.getName(),
				    field.getType().getCanonicalName(),
				    annot.annotationType().getCanonicalName(),
				    Arrays.toString(expectedType())));
			}
		}

	}

	public abstract Class<?>[] expectedType();
}
