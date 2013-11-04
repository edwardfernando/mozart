package mozart.api.model.query;

import mozart.core.pagination.FilterableQuery;

public class AdvertiserTypeQuery extends FilterableQuery {

	@Override
	public String getQuery() {
		return "select a from AdvertiserType a where a.id is not null";
	}

}
