package mozart.api.dao;

import mozart.api.model.Buzzer;
import mozart.core.db.AbstractDAO;

import org.springframework.stereotype.Component;

@Component
public class BuzzerDAO extends AbstractDAO<Buzzer> {

	@Override
	protected Class<Buzzer> getModel() {
		return Buzzer.class;
	}

}
