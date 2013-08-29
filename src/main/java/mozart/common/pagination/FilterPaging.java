package mozart.common.pagination;

import java.util.List;

public class FilterPaging {

	public static synchronized List<Object> filter(Filterable dao, FilterableQuery query) {
		int totalData = 0;
		int totalPage = 1;
		int nextPage = 1;
		int prevPage = 1;

		totalData = dao.count(query).intValue();

		if (totalData > 0) {
			if (totalData % query.getFilterCriteria().getMax() == 0) {
				totalPage = totalData / query.getFilterCriteria().getMax();
			} else {
				int dataLeft = totalData % query.getFilterCriteria().getMax();
				totalPage = ((totalData - dataLeft) / query.getFilterCriteria().getMax()) + 1;
			}

			if (query.getFilterCriteria().getPage() - 1 > 0) {
				prevPage = query.getFilterCriteria().getPage() - 1;
			}

			if (query.getFilterCriteria().getPage() + 1 <= totalPage) {
				nextPage = query.getFilterCriteria().getPage() + 1;
			} else {
				nextPage = totalPage;
			}
		}

		query.getFilterCriteria().setNextPage(nextPage);
		query.getFilterCriteria().setPrevPage(prevPage);
		query.getFilterCriteria().setTotalPage(totalPage);

		return dao.filter(query);
	}

}
