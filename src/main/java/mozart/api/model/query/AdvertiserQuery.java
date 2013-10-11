package mozart.api.model.query;

import java.util.List;

import mozart.api.dao.AdvertiserDAO;
import mozart.core.pagination.FilterCriteria;
import mozart.core.pagination.FilterableQuery;

import org.hibernate.Query;
import org.hibernate.Session;

public class AdvertiserQuery extends FilterableQuery {

	@Override
	public List<?> execute() {

		AdvertiserDAO dao = (AdvertiserDAO) getFilterableDao();
		FilterCriteria filter = getFilterCriteria();

		StringBuffer buffer = new StringBuffer();
		buffer.append("select a from Advertiser a where a.id is not null");

		Session session = getSession();
		Query query = session.createQuery(buffer.toString());

		query.setFirstResult(filter.start());
		query.setMaxResults(filter.getMax());

		return (List<?>) dao.execList(query);
	}

}
