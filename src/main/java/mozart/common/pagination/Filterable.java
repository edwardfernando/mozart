package mozart.common.pagination;

import java.util.List;

/**
 * 
 * @author Edward Fernando
 * 
 */
public interface Filterable {

	public List filter(FilterableQuery query);

	public Long count(FilterableQuery query);
}
