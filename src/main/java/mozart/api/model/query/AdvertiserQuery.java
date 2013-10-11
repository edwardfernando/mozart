package mozart.api.model.query;

import java.util.List;

import mozart.api.dao.AdvertiserDAO;
import mozart.common.exception.MozartException;
import mozart.common.pagination.FilterCriteria;
import mozart.common.pagination.FilterableQuery;

import org.hibernate.Query;

public class AdvertiserQuery extends FilterableQuery {

	@Override
	public List<?> execute() throws MozartException {
		AdvertiserDAO dao = (AdvertiserDAO) getFilterableDao();
		FilterCriteria filter = getFilterCriteria();

		StringBuffer buffer = new StringBuffer();
		buffer.append("select a from Advertiser a where a.id is not null");

		Query query = getSession().createQuery(buffer.toString());

		query.setFirstResult(filter.start());
		query.setMaxResults(filter.getMax());

		return (List<?>) dao.execList(query);
	}

}
