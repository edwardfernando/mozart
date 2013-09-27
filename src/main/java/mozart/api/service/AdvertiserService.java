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
	public void save(HttpServletRequest request) throws MozartException {
		Advertiser adv = new Advertiser();
		adv.setOrganizationName(request.getParameter("organization_name"));
		adv.setOrganizationType(request.getParameter("organization_type"));
		adv.setAddress(request.getParameter("address"));
		adv.setCountry(request.getParameter("country"));
		adv.setState(request.getParameter("state"));
		adv.setCity(request.getParameter("city"));
		adv.setPhoneCountryCode(request.getParameter("phone_country_code"));
		adv.setPhoneAreaCode(request.getParameter("phone_area_code"));
		adv.setPhoneNumber(request.getParameter("phone_number"));
		adv.setFaxCountryCode(request.getParameter("fax_country_code"));
		adv.setFaxAreaCode(request.getParameter("fax_area_code"));
		adv.setFaxNumber(request.getParameter("fax_number"));
		adv.setEmail(request.getParameter("email"));
		adv.setPassword(request.getParameter("password"));

		dao.save(adv);
	}
}
