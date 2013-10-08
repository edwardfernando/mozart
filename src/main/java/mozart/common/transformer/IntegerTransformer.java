package mozart.common.transformer;

import java.lang.reflect.Field;

import mozart.common.exception.MozartException;

import org.apache.commons.lang3.StringUtils;

public class IntegerTransformer extends Transformer<Integer> {

	@Override
	public Integer transform(Field field, String value) throws MozartException {
		return StringUtils.isNumeric(value) ? Integer.valueOf(value) : 0;
	}

}
