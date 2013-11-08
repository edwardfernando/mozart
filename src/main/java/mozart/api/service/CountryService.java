package mozart.api.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mozart.core.api.Service;
import mozart.core.datasource.CountryDataSource;
import mozart.core.datasource.pojo.Country;
import mozart.core.db.AbstractDAO;
import mozart.core.exception.MozartException;
import mozart.core.pagination.FilterCriteria;
import mozart.core.pagination.FilterableQuery;

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
		return CountryDataSource.instance().getCountriesList();
	}

	@Override
	public List<Country> loadAll(HttpServletRequest arg0, Class<? extends FilterCriteria> arg1,
	        Class<? extends FilterableQuery> arg2) throws MozartException {
		return super.loadAll(arg0, arg1, arg2);
	}

	@Override
	public Country loadById(String id) throws MozartException {
		Map<String, Country> countries = CountryDataSource.instance().getCountriesMap();
		String capitalizedId = id.toUpperCase();

		if (!countries.containsKey(capitalizedId)) {
			throw new MozartException(String.format(
			    "No country found with code %s. Please use two digits ISO code for country code",
			    id));
		}

		return countries.get(capitalizedId);
	}

	@Override
	public void save(HttpServletRequest request) throws MozartException {
		super.save(request);
	}

}
