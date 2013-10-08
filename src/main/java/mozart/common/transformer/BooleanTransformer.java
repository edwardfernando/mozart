package mozart.common.transformer;

import java.lang.reflect.Field;

import mozart.common.exception.MozartException;

public class BooleanTransformer extends Transformer<Boolean> {

	@Override
	public Boolean transform(Field field, String value) throws MozartException {
		return Boolean.valueOf(value);
	}

}
