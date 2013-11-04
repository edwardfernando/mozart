package mozart.api.model.query;

import mozart.core.pagination.FilterableQuery;

public class AdvertiserQuery extends FilterableQuery {

	@Override
	public String getQuery() {
		return "select a from Advertiser a where a.id is not null";
	}

}
