package mozart.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public abstract class AbstractDAO<T> {

	@Autowired
	private MongoTemplate template;

	protected abstract Class<T> getModel();

	public List<T> loadAll() {
		return template.findAll(getModel(), getModel().getSimpleName());
	}

	public T loadById(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		return template.findOne(query, getModel(), getModel().getSimpleName());
	}

	public void save(T model) {
		if (!template.collectionExists(getModel())) {
			template.createCollection(getModel());
		}
		template.save(model, getModel().getSimpleName());
	}

	public void delete(T model) {
		template.remove(model, getModel().getSimpleName());
	}
}
