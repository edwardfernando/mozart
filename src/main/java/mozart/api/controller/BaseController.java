package mozart.api.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;

import mozart.api.service.Service;
import mozart.common.exception.MozartException;

import org.springframework.stereotype.Component;

@Component
public abstract class BaseController<T> {

	protected abstract Service<T> getService();

	protected abstract Type getType();

	@GET
	@Path("")
	public GenericEntity<List<T>> getAll() {
		return new GenericEntity<List<T>>(getService().loadAll(), new MozartParameterizedType());
	}

	@GET
	@Path("/{id}")
	public T loadById(@PathParam("id") String id) throws MozartException {
		return getService().loadById(id);
	}

	@GET
	@Path("/delete/{id}")
	public void delete(@PathParam("id") String id) throws MozartException {
		getService().delete(id);
	}

	private class MozartParameterizedType implements ParameterizedType {

		@Override
		public Type[] getActualTypeArguments() {
			return new Type[] { getType() };
		}

		@Override
		public Type getRawType() {
			return List.class;
		}

		@Override
		public Type getOwnerType() {
			return List.class;
		}

	}
}
