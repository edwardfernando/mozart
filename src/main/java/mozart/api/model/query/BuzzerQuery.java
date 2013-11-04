package mozart.api.model.query;

import mozart.core.pagination.FilterableQuery;

public class BuzzerQuery extends FilterableQuery {

	@Override
	public String getQuery() {
		return "select a from Buzzer a where a.id is not null";
	}

}
