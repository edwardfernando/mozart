package mozart.api.dao;

import java.util.List;

import mozart.common.pagination.Filterable;
import mozart.common.pagination.FilterableQuery;

public abstract class AbstractDAO<T> implements Filterable {

	public abstract Class<T> getModel();

	public List<T> loadAll() {
		return null;
	}

	public T loadById(String id) {
		return null;
	}

	public void save(T model) {
	}

	public void delete(T model) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> filter(FilterableQuery query) {
		query.setFilterable(this);
		return query.execute();
	}

	@Override
	public Long count(FilterableQuery query) {
		query.setFilterable(this);
		return query.count();
	}
}
