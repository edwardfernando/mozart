package mozart.api.service;

import javax.servlet.http.HttpServletRequest;

import mozart.api.dao.AdvertiserDAO;
import mozart.api.model.Advertiser;
import mozart.core.api.Service;
import mozart.core.db.AbstractDAO;
import mozart.core.exception.MozartException;

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

	public Advertiser login(HttpServletRequest request) throws MozartException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");

		Advertiser adv = dao.load(username, password);

		if (adv == null) {
			throw new MozartException("Not found / wrong password");
		}

		return adv;
	}
}
