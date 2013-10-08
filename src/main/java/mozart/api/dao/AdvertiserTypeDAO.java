package mozart.api.dao;

import mozart.api.model.AdvertiserType;

import org.springframework.stereotype.Component;

@Component
public class AdvertiserTypeDAO extends AbstractDAO<AdvertiserType> {

	@Override
	protected Class<AdvertiserType> getModel() {
		return AdvertiserType.class;
	}

}
