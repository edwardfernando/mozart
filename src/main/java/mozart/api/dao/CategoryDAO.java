package mozart.api.dao;

import mozart.api.model.Category;
import mozart.core.db.AbstractDAO;

import org.springframework.stereotype.Component;

@Component
public class CategoryDAO extends AbstractDAO<Category> {

	@Override
	protected Class<Category> getModel() {
		return Category.class;
	}

}
