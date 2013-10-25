package mozart.api.service;

import mozart.api.dao.CampaignDAO;
import mozart.api.model.Campaign;
import mozart.core.api.Service;
import mozart.core.db.AbstractDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignService extends Service<Campaign> {

	@Autowired
	private CampaignDAO dao;

	@Override
	protected AbstractDAO<Campaign> getDao() {
		return dao;
	}

	@Override
	protected Class<Campaign> getModel() {
		return Campaign.class;
	}

}
