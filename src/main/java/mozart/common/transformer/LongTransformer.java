package mozart.common.transformer;

import java.lang.reflect.Field;

import mozart.common.exception.MozartException;

import org.apache.commons.lang3.StringUtils;

public class LongTransformer extends Transformer<Long> {

	@Override
	public Long transform(Field field, String value) throws MozartException {
		return StringUtils.isNumeric(value) ? Long.valueOf(value) : 0;
	}

}
