package com.lunifera.geo.store.api.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrFilter implements Filter {

	List<Filter> filters = new ArrayList<>();

	public OrFilter(Filter... filters) {
		this.filters.addAll(Arrays.asList(filters));
	}

	public void add(Filter filter) {
		filters.add(filter);
	}

	public List<Filter> getFilters() {
		return Collections.unmodifiableList(filters);
	}

}
