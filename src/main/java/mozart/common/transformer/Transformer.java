package mozart.common.transformer;

import java.lang.reflect.Field;

public abstract class Transformer<T> {

	public abstract T transform(Field field, String value);

}
