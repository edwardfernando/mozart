package mozart.api.model.query;

import mozart.core.pagination.FilterableQuery;

public class CategoryQuery extends FilterableQuery {

	@Override
	public String getQuery() {
		return "select a from Category a where a.id is not null";
	}

}
