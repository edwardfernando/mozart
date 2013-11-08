package mozart.api.dao;

import mozart.api.model.Buzzer;
import mozart.core.db.AbstractDAO;
import mozart.core.exception.MozartException;

import org.springframework.stereotype.Component;

@Component
public class BuzzerDAO extends AbstractDAO<Buzzer> {

	@Override
	protected Class<Buzzer> getModel() {
		return Buzzer.class;
	}

	public Buzzer loadByEmail(String email) throws MozartException {
		Buzzer buzzer = (Buzzer) execUnique("from Buzzer b where b.email = ?", email);
		return buzzer;
	}

}
