package mozart.api.service;

import java.util.List;

import mozart.api.dao.AbstractDAO;
import mozart.common.exception.MozartException;

public abstract class Service<T> {

	protected abstract AbstractDAO<T> getDao();

	public List<T> loadAll() {
		return getDao().loadAll();
	}

	public T loadById(String id) throws MozartException {
		T obj = getDao().loadById(id);
		if (obj == null) {
			throw new MozartException("Resource '" +
			                          getDao().getModel().getSimpleName().toLowerCase() +
			                          "' with identifier '" +
			                          id +
			                          "' is not found");
		}
		return obj;
	}

	public void save(T model) {
		getDao().save(model);
	}

	public void update(T model) {
		save(model);
	}

	public void delete(String id) throws MozartException {
		T obj = getDao().loadById(id);
		if (obj == null) {
			throw new MozartException("Resource '" +
			                          getDao().getModel().getSimpleName().toLowerCase() +
			                          "' with identifier '" +
			                          id +
			                          "' is not found");
		}
		getDao().delete(obj);
	}
}
