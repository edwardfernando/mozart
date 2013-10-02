package mozart.common.checker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

import com.google.common.collect.Sets;

public abstract class Checker {
	private final String exceptionMessage = "\n[Source: %s][Field/Type: %s/%s] : Annotation %s only applicable for %s";

	public void check(Class<?> source, Field field, Annotation annot) throws Throwable {

		if (!supportedTypes().contains(field.getType())) {
			throw new Throwable(String.format(
			    exceptionMessage,
			    source.getCanonicalName(),
			    field.getName(),
			    field.getType().getCanonicalName(),
			    annot.annotationType().getCanonicalName(),
			    supportedTypes()));
		}

	}

	public abstract Set<Class<?>> supportedTypes();

	public Set<Class<?>> addSupportedType(Class<?>... classes) {
		Set<Class<?>> set = Sets.newHashSet();

		for (Class<?> clazz : classes) {
			set.add(clazz);
		}

		return set;
	}
}
