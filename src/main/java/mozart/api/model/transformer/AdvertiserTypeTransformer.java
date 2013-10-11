package mozart.api.model.transformer;

import java.lang.reflect.Field;

import mozart.api.dao.AdvertiserTypeDAO;
import mozart.api.model.AdvertiserType;
import mozart.core.exception.MozartException;
import mozart.core.transformer.Transformer;

import org.springframework.beans.factory.annotation.Autowired;

public class AdvertiserTypeTransformer extends Transformer<AdvertiserType> {

	@Autowired
	private AdvertiserTypeDAO dao;

	@Override
	public AdvertiserType transform(Field field, String value) throws MozartException {
		AdvertiserType type = dao.loadById(Long.valueOf(value));

		if (type == null) {
			throw new MozartException(
			                          String
			                              .format("AdvertiserType with id %s is not found", value));
		}

		return type;
	}

}
