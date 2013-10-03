package mozart.common.transformer;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

public class LongTransformer extends Transformer<Long> {

	@Override
	public Long transform(Field field, String value) {
		return StringUtils.isNumeric(value) ? Long.valueOf(value) : 0;
	}

}
