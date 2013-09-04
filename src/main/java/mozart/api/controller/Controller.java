package mozart.api.controller;

import mozart.api.model.CollectionWrapper;

public abstract class Controller<T> {
	public abstract CollectionWrapper loadAll();

	public abstract T loadById(String id);

	public abstract void save(T model);

	public abstract T update(T model);

	public abstract void delete(T model);
}
