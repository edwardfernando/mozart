package mozart.api.service;

import mozart.api.dao.CategoryDAO;
import mozart.api.model.Category;
import mozart.core.api.Service;
import mozart.core.db.AbstractDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService extends Service<Category> {

	@Autowired
	private CategoryDAO dao;

	@Override
	protected AbstractDAO<Category> getDao() {
		return dao;
	}

	@Override
	protected Class<Category> getModel() {
		return Category.class;
	}

}
