package mozart.common.pagination;

import java.util.List;

public interface FilterableQuery {
	public Filterable getFilterable();

	public void setFilterable(Filterable filterable);

	public FilterCriteria getFilterCriteria();

	public void setFilterCriteria(FilterCriteria filterCriteria);

	public Long count();

	public List execute();
}
