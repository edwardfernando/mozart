package mozart.api.model.query;

import mozart.core.pagination.FilterableQuery;

public class CampaignQuery extends FilterableQuery {

	@Override
	public String getQuery() {
		return "select a from Campaign a where a.id is not null";
	}

}
