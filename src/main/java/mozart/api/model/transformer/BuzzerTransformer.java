package mozart.api.model.transformer;

import java.lang.reflect.Field;

import mozart.api.dao.BuzzerDAO;
import mozart.api.model.Buzzer;
import mozart.core.exception.MozartException;
import mozart.core.transformer.Transformer;

import org.springframework.beans.factory.annotation.Autowired;

public class BuzzerTransformer extends Transformer<Buzzer> {

	@Autowired
	private BuzzerDAO dao;

	@Override
	public Buzzer transform(Field field, String value) throws MozartException {
		Buzzer type = dao.loadById(Long.valueOf(value));
		return validate(type, field, value);
	}

}
