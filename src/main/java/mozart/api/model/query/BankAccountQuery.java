package mozart.api.model.query;

import mozart.core.pagination.FilterableQuery;

public class BankAccountQuery extends FilterableQuery {

	@Override
	public String getQuery() {
		return "select a from BankAccount a where a.id is not null";
	}

}
