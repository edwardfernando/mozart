package mozart.api.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mozart.api.dao.AbstractDAO;
import mozart.common.exception.MozartException;
import mozart.common.transformer.TransformerUtil;

public abstract class Service<T> {

	protected abstract AbstractDAO<T> getDao();

	protected abstract Class<T> getModel();

	public List<T> loadAll() {
		return getDao().loadAll();
	}

	public T loadById(Long id) throws MozartException {
		T obj = getDao().loadById(id);
		if (obj == null) {
			throw new MozartException("Resource '" +
			                          getModel().getSimpleName().toLowerCase() +
			                          "' with identifier '" +
			                          id +
			                          "' is not found");
		}
		return obj;
	}

	public void save(HttpServletRequest request) throws MozartException {
		throw new MozartException("Unrecognized POST action for " +
		                          request.getPathInfo() +
		                          " in service layer");
	}

	public void delete(Long id) throws MozartException {
		T obj = getDao().loadById(id);
		if (obj == null) {
			throw new MozartException("Resource '" +
			                          getModel().getSimpleName().toLowerCase() +
			                          "' with identifier '" +
			                          id +
			                          "' is not found");
		}
		getDao().delete(obj);
	}

	protected T transform(HttpServletRequest request) throws MozartException {
		return TransformerUtil.instance().fromRequest(request, getModel());
	}
}
