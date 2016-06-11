package com.lunifera.geo.store.hbase.provider;

import java.time.LocalDateTime;

import com.lunifera.geo.store.api.dto.AreaGeometryDTO;
import com.lunifera.geo.store.api.dto.LineGeometryDTO;
import com.lunifera.geo.store.api.query.AndFilter;
import com.lunifera.geo.store.api.query.FieldFilter;
import com.lunifera.geo.store.api.query.Filter;
import com.lunifera.geo.store.api.query.IntersectsFilter;
import com.lunifera.geo.store.api.query.NotFilter;
import com.lunifera.geo.store.api.query.OrFilter;
import com.lunifera.geo.store.api.query.Query;
import com.lunifera.geo.store.api.query.QueryBuilder;
import com.lunifera.geo.store.api.query.WithinFilter;

public class QueryBuilderImpl implements QueryBuilder {

	@Override
	public FieldFilter filter(String field, CompareType compareType, Object value) {
		return new FieldFilter(field, compareType, value);
	}

	@Override
	public FieldFilter timestamp(CompareType compareType, LocalDateTime timestamp) {
		return new FieldFilter(GeoConstants.COL_TIMESTAMP, compareType, timestamp);
	}

	@Override
	public FieldFilter subjectId(CompareType compareType, String subjectId) {
		return new FieldFilter(GeoConstants.COL_SUBJECT_ID, compareType, subjectId);
	}

	@Override
	public WithinFilter within(AreaGeometryDTO within) {
		return new WithinFilter(within);
	}

	@Override
	public IntersectsFilter intersects(LineGeometryDTO intersects) {
		return new IntersectsFilter(intersects);
	}

	@Override
	public OrFilter or(com.lunifera.geo.store.api.query.Filter... filters) {
		return new OrFilter(filters);
	}

	@Override
	public AndFilter and(com.lunifera.geo.store.api.query.Filter... filters) {
		return new AndFilter(filters);
	}

	@Override
	public NotFilter not(Filter filter) {
		return new NotFilter(filter);
	}

	@Override
	public Query build(com.lunifera.geo.store.api.query.Filter filter) {
		return new QueryImpl(filter);
	}
}
