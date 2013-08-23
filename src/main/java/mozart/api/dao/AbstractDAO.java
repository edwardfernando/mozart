package mozart.api.dao;

import java.util.List;

public abstract class AbstractDAO<T> {

	protected abstract Class<T> getModel();

	public List<T> loadAll() {
		return null;
	}

	public T save(T model) {
		return null;
	}

	public T update(T model) {
		return null;
	}

	public T delete(T model) {
		return null;
	}
}
