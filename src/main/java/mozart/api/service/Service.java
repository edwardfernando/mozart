package mozart.api.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mozart.core.db.AbstractDAO;
import mozart.core.exception.MozartException;
import mozart.core.pagination.FilterCriteria;
import mozart.core.pagination.FilterPaging;
import mozart.core.pagination.FilterableQuery;
import mozart.core.transformer.TransformerUtil;

import org.apache.commons.lang3.StringUtils;

public abstract class Service<T> {

	protected abstract AbstractDAO<T> getDao();

	protected abstract Class<T> getModel();

	public List<T> loadAll() throws MozartException {
		return getDao().loadAll();
	}

	@SuppressWarnings("unchecked")
	public List<T> loadAll(HttpServletRequest request,
	        Class<? extends FilterCriteria> filterCriteria,
	        Class<? extends FilterableQuery> filterableQuery) throws MozartException {

		List<T> list = null;

		if (StringUtils.isBlank(request.getParameter("page"))) {
			list = loadAll();
		} else {
			FilterCriteria filter = TransformerUtil.instance().toFilterCriteria(
			    request,
			    filterCriteria);

			FilterableQuery query = TransformerUtil.instance().toFilterableQuery(
			    filter,
			    filterableQuery);

			list = (List<T>) FilterPaging.filter(getDao(), query);
		}

		return list;

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
		return TransformerUtil.instance().toModel(request, getModel());
	}
}
