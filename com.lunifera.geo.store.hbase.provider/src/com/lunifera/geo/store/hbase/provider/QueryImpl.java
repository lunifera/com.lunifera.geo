package com.lunifera.geo.store.hbase.provider;

import com.lunifera.geo.store.api.GeoStoreConstants;
import com.lunifera.geo.store.api.query.Filter;
import com.lunifera.geo.store.api.query.Query;

public class QueryImpl implements Query {

	private final Filter filter;
	private int limit = GeoStoreConstants.DFLT_QUERY_LIMIT;

	public QueryImpl(Filter filter) {
		super();
		this.filter = filter;
	}

	@Override
	public Filter getFilter() {
		return filter;
	}

	@Override
	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public int getLimit() {
		return limit;
	}

}
