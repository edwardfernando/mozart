package mozart.api.service;

import mozart.api.dao.AdvertiserTypeDAO;
import mozart.api.model.AdvertiserType;
import mozart.core.api.Service;
import mozart.core.db.AbstractDAO;

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
