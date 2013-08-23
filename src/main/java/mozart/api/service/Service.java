package mozart.api.service;

import java.util.List;

public interface Service<T> {

	public List<T> loadAll();

	public T loadById(String id);

	public void save(T model);

	public T update(T model);

	public void delete(T model);
}
