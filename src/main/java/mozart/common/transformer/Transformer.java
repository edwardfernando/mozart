package mozart.common.transformer;

import java.lang.reflect.Field;

import mozart.common.exception.MozartException;

public abstract class Transformer<T> {

	public abstract T transform(Field field, String value) throws MozartException;

}
