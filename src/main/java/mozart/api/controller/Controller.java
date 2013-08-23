package mozart.api.controller;

import java.util.List;

public abstract class Controller<T> {
	public abstract List<T> loadAll();

	public abstract T loadById(String id);

	public abstract void save(T model);

	public abstract T update(T model);

	public abstract void delete(T model);
}
