package mozart.api.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import mozart.api.service.Service;
import mozart.common.exception.MozartException;

import org.springframework.stereotype.Component;

@Component
public abstract class Controller<T> {

	@GET
	@Path("")
	public Response loadAll() {
		GenericEntity<List<T>> ge = new GenericEntity<List<T>>(
		                                                       getService().loadAll(),
		                                                       new MozartParameterizedType());

		return Response.ok(ge).build();
	}

	@GET
	@Path("/{id}")
	public Response loadById(@PathParam("id") String id) throws MozartException {
		return Response.ok(getService().loadById(id)).build();
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

	protected abstract Service<T> getService();

	protected abstract Type getType();
}
