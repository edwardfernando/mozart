package mozart.common.transformer;

import java.lang.reflect.Field;

public class StringTransformer extends Transformer<String> {

	@Override
	public String transform(Field field, String value) {
		return value;
	}

}
