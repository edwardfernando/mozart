package mozart.common.pagination;

import java.util.List;

import mozart.common.exception.MozartException;

/**
 * 
 * @author Edward Fernando
 * 
 */
public interface FilterableDao {

	public <T> List<T> filter(FilterableQuery query) throws MozartException;

}
