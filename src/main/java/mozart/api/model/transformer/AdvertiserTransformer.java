package mozart.api.model.transformer;

import java.lang.reflect.Field;

import mozart.api.dao.AdvertiserDAO;
import mozart.api.model.Advertiser;
import mozart.core.exception.MozartException;
import mozart.core.transformer.Transformer;

import org.springframework.beans.factory.annotation.Autowired;

public class AdvertiserTransformer extends Transformer<Advertiser> {

	@Autowired
	private AdvertiserDAO dao;

	@Override
	public Advertiser transform(Field field, String value) throws MozartException {
		Advertiser type = dao.loadById(Long.valueOf(value));
		return validate(type, field, value);
	}

}
