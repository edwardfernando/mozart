package mozart.common.pagination;

import java.util.List;

public class FilterPaging<T> {

	public List<T> filter(FilterableDao dao, FilterableQuery query) {
		int totalData = 0;
		int totalPage = 1;
		int nextPage = 1;
		int prevPage = 1;

		List<T> list = dao.filter(query);
		// totalData = dao.count(query).intValue();
		totalData = list.size();

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

		// return dao.filter(query);

		return list;
	}

}
