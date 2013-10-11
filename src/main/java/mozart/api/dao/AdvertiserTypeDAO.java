package mozart.api.dao;

import mozart.api.model.AdvertiserType;
import mozart.core.db.AbstractDAO;

import org.springframework.stereotype.Component;

@Component
public class AdvertiserTypeDAO extends AbstractDAO<AdvertiserType> {

	@Override
	protected Class<AdvertiserType> getModel() {
		return AdvertiserType.class;
	}

}
