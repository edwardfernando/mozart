package mozart.api.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import mozart.common.config.ControllerConfig;
import mozart.common.exception.MozartException;

import org.springframework.stereotype.Component;

@Component
public abstract class Controller<T> {

	@GET
	@Path("")
	public Response loadAll() {
		GenericEntity<List<T>> ge = new GenericEntity<List<T>>(
		                                                       getConfig().getService().loadAll(),
		                                                       new MozartParameterizedType());
		return Response.ok(ge).build();
	}

	@GET
	@Path("/{id}")
	public Response loadById(@PathParam("id") Long id) throws MozartException {
		return Response.ok(getConfig().getService().loadById(id)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) throws MozartException {
		getConfig().getService().delete(id);
		return Response.ok().build();
	}

	@POST
	@Path("")
	public Response save(@Context HttpServletRequest request) throws MozartException {
		throw new MozartException("Unrecognized POST action for " + request.getPathInfo());
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") Long id, @Context HttpServletRequest request)
	        throws MozartException {
		throw new MozartException("Unrecognized PUT action for " + request.getPathInfo());
	}

	private class MozartParameterizedType implements ParameterizedType {

		@Override
		public Type[] getActualTypeArguments() {
			return new Type[] { getConfig().getType() };
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

	protected abstract ControllerConfig<T> getConfig();
}
