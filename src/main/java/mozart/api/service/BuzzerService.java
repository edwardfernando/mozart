package mozart.api.service;

import mozart.api.dao.BuzzerDAO;
import mozart.api.model.Buzzer;
import mozart.core.api.Service;
import mozart.core.db.AbstractDAO;

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

}
