package mozart.api.service;

import javax.servlet.http.HttpServletRequest;

import mozart.api.dao.AdvertiserTypeDAO;
import mozart.api.model.AdvertiserType;
import mozart.core.api.Service;
import mozart.core.db.AbstractDAO;
import mozart.core.exception.MozartException;

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

	@Override
	public void save(HttpServletRequest request) throws MozartException {
		AdvertiserType type = transform(request);
		dao.save(type);
	}
}
