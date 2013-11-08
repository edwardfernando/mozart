package mozart.api.service;

import java.util.List;
import java.util.Map;

import mozart.core.api.Service;
import mozart.core.datasource.CountryDataSource;
import mozart.core.datasource.pojo.Country;
import mozart.core.db.AbstractDAO;
import mozart.core.exception.MozartException;

import org.springframework.stereotype.Component;

@Component
public class CountryService extends Service<Country> {

	@Override
	protected AbstractDAO<Country> getDao() {
		return null;
	}

	@Override
	protected Class<Country> getModel() {
		return Country.class;
	}

	@Override
	public List<Country> loadAll() throws MozartException {
		return CountryDataSource.instance().getList();
	}

	@Override
	public Country loadById(String id) throws MozartException {
		Map<String, Country> countries = CountryDataSource.instance().getMap();
		String capitalizedId = id.toUpperCase();

		if (!countries.containsKey(capitalizedId)) {
			throw new MozartException(String.format(
			    "No country found with code %s. Please use two digits ISO code for country code",
			    id));
		}

		return countries.get(capitalizedId);
	}

}
