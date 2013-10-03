package mozart.common.transformer;

import java.lang.reflect.Field;

public class BooleanTransformer extends Transformer<Boolean> {

	@Override
	public Boolean transform(Field field, String value) {
		return Boolean.valueOf(value);
	}

}
