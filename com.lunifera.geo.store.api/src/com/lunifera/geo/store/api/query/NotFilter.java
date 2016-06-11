package com.lunifera.geo.store.api.query;

public class NotFilter implements Filter {

	final Filter filter;

	public NotFilter(Filter filter) {
		this.filter = filter;
	}

	public Filter getFilter() {
		return filter;
	}

}
