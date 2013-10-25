package mozart.api.controller.crud;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mozart.api.model.Category;
import mozart.api.service.CategoryService;
import mozart.core.annotation.ExpectParam;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;
import mozart.core.exception.MozartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/campaign/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryController extends Controller<Category> {

	@Autowired
	private CategoryService service;

	@Override
	protected ControllerConfig<Category> getConfig() {
		return new ControllerConfig<Category>().build(service, Category.class);
	}

	@Override
	@ExpectParam(Category.class)
	public Response save(HttpServletRequest request) throws MozartException {
		service.save(request);
		return Response.ok().build();
	}
}
