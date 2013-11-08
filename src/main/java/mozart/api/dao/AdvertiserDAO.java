package mozart.api.dao;

import mozart.api.model.Advertiser;
import mozart.core.db.AbstractDAO;
import mozart.core.exception.MozartException;

import org.springframework.stereotype.Component;

@Component
public class AdvertiserDAO extends AbstractDAO<Advertiser> {

	@Override
	public Class<Advertiser> getModel() {
		return Advertiser.class;
	}

	public Advertiser load(String username, String password) throws MozartException {
		return (Advertiser) execUnique(
		    "from Advertiser a where a.email = ?  and a.password = ?",
		    username,
		    password);
	}

	public Advertiser loadByEmail(String email) throws MozartException {
		Advertiser advertiser = (Advertiser) execUnique(
		    "from Advertiser a where a.email = ?",
		    email);
		return advertiser;
	}
}
