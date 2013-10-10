package mozart.common.pagination;

import java.util.List;

/**
 * 
 * @author Edward Fernando
 * 
 */
public interface FilterableDao {

	public <T> List<T> filter(FilterableQuery query);

	// public Long count(FilterableQuery query);
}
