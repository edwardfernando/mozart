package mozart.api.service.advertiser;

import mozart.api.dao.AbstractDAO;
import mozart.api.dao.AdvertiserTypeDAO;
import mozart.api.model.AdvertiserType;
import mozart.api.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvertiserTypeService extends Service<AdvertiserType> {

	@Autowired
	private AdvertiserTypeDAO dao;

	@Override
	protected AbstractDAO<AdvertiserType> getDao() {
		return dao;
	}

	@Override
	protected Class<AdvertiserType> getModel() {
		return AdvertiserType.class;
	}

}
