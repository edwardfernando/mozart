package mozart.api.service;

import java.util.List;
import java.util.Map;

import mozart.core.api.Service;
import mozart.core.datasource.AdvertiserTypeDataSource;
import mozart.core.datasource.pojo.AdvertiserType;
import mozart.core.db.AbstractDAO;
import mozart.core.exception.MozartException;

import org.springframework.stereotype.Component;

@Component
public class AdvertiserTypeService extends Service<AdvertiserType> {

	@Override
	protected AbstractDAO<AdvertiserType> getDao() {
		return null;
	}

	@Override
	protected Class<AdvertiserType> getModel() {
		return AdvertiserType.class;
	}

	@Override
	public List<AdvertiserType> loadAll() throws MozartException {
		return AdvertiserTypeDataSource.instance().getList();
	}

	@Override
	public AdvertiserType loadById(String id) throws MozartException {
		Map<String, AdvertiserType> advertiserType = AdvertiserTypeDataSource.instance().getMap();
		String capitalizedId = id.toUpperCase();

		if (!advertiserType.containsKey(capitalizedId)) {
			throw new MozartException(String.format("No AdvertiserType found with code %s", id));
		}

		return advertiserType.get(capitalizedId);
	}
}
