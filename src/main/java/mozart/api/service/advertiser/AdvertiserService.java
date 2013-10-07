package mozart.api.service.advertiser;

import javax.servlet.http.HttpServletRequest;

import mozart.api.dao.AbstractDAO;
import mozart.api.dao.AdvertiserDAO;
import mozart.api.model.Advertiser;
import mozart.api.service.Service;
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
		dao.save(advertiser);
	}

	public Advertiser login(HttpServletRequest request) throws MozartException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		return null;
	}
}
