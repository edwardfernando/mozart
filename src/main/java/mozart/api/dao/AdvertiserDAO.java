package mozart.api.dao;

import mozart.api.model.Advertiser;

import org.springframework.stereotype.Component;

@Component
public class AdvertiserDAO extends AbstractDAO<Advertiser> {

	@Override
	public Class<Advertiser> getModel() {
		return Advertiser.class;
	}

}
