package mozart.api.service;

import javax.servlet.http.HttpServletRequest;

import mozart.api.dao.AbstractDAO;
import mozart.api.dao.AdvertiserDAO;
import mozart.api.model.Advertiser;
import mozart.common.exception.MozartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvertiserService extends Service<Advertiser> {

	@Autowired
	private AdvertiserDAO dao;

	@Override
	protected AbstractDAO<Advertiser> getDao() {
		return dao;
	}

	@Override
	protected Class<Advertiser> getModel() {
		return Advertiser.class;
	}

	@Override
	public void save(HttpServletRequest request) throws MozartException {
		Advertiser advertiser = transform(request);
	}

}
