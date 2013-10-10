package mozart.common.pagination;

import java.util.List;

import org.hibernate.Session;

public abstract class FilterableQuery {

	private FilterableDao filterableDao;
	private Session session;
	private FilterCriteria filterCriteria;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public FilterCriteria getFilterCriteria() {
		return filterCriteria;
	}

	public void setFilterCriteria(FilterCriteria filterCriteria) {
		this.filterCriteria = filterCriteria;
	}

	public FilterableDao getFilterableDao() {
		return filterableDao;
	}

	public void setFilterableDao(FilterableDao filterableDao) {
		this.filterableDao = filterableDao;
	}

	// public abstract Long count();

	public abstract List<?> execute();

}
