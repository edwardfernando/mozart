package mozart.api.dao;

import mozart.api.model.Campaign;
import mozart.core.db.AbstractDAO;

import org.springframework.stereotype.Component;

@Component
public class CampaignDAO extends AbstractDAO<Campaign> {

	@Override
	protected Class<Campaign> getModel() {
		return Campaign.class;
	}

}
