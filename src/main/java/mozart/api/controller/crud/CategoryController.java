package mozart.api.controller.crud;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mozart.api.model.Category;
import mozart.api.service.CategoryService;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;

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

}
