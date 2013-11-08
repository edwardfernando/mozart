package mozart.api.service;

import javax.servlet.http.HttpServletRequest;

import mozart.api.dao.BuzzerDAO;
import mozart.api.model.Buzzer;
import mozart.core.api.Service;
import mozart.core.datasource.CountryDataSource;
import mozart.core.db.AbstractDAO;
import mozart.core.exception.MozartException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuzzerService extends Service<Buzzer> {

	@Autowired
	private BuzzerDAO dao;

	@Override
	protected AbstractDAO<Buzzer> getDao() {
		return dao;
	}

	@Override
	protected Class<Buzzer> getModel() {
		return Buzzer.class;
	}

	@Override
	public void save(HttpServletRequest request) throws MozartException {
		String salt = BCrypt.gensalt();

		Buzzer buzzer = transform(request);

		Buzzer anotherBuzzer = dao.loadByEmail(buzzer.getEmail());
		if (anotherBuzzer != null) {
			throw new MozartException("Email already exist");
		}

		if (!CountryDataSource.instance().getMap().containsKey(buzzer.getCountry())) {
			throw new MozartException(String.format(
			    "No country found with code %s. Please use two digits ISO code for country code",
			    buzzer.getCountry()));
		}

		String password = BCrypt.hashpw(buzzer.getPassword(), salt);

		buzzer.setPassword(password);
		buzzer.setSalt(salt);

		dao.save(buzzer);
	}

}
