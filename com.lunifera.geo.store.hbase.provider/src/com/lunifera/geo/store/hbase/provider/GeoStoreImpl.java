package com.lunifera.geo.store.hbase.provider;

import java.util.Map;

import org.osgi.namespace.implementation.ImplementationNamespace;
import org.osgi.service.component.annotations.Component;

import com.lunifera.geo.store.api.GeoStore;
import com.lunifera.geo.store.api.GeoStoreConstants;
import com.lunifera.geo.store.api.dto.SubjectLocationDTO;
import com.lunifera.geo.store.api.query.Filter;
import com.lunifera.geo.store.api.query.Query;
import com.lunifera.geo.store.api.query.QueryBuilder;

import aQute.bnd.annotation.headers.ProvideCapability;

/**
 * 
 */
@ProvideCapability(ns = ImplementationNamespace.IMPLEMENTATION_NAMESPACE, name = GeoStoreConstants.SPECIFICATION_NAME, version = GeoStoreConstants.SPECIFICATION_VERSION)
@Component(name = "com.lunifera.geo.hbase", property = { "storetype=hbase" })
public class GeoStoreImpl implements GeoStore {

	@Override
	public QueryBuilder createBuilder(Map<Object, Object> properties) {
		return new QueryBuilderImpl();
	}

	@Override
	public Iterable<SubjectLocationDTO> query(Query query) {
		Filter filter = query.getFilter();

		return callREST(filter, query.getLimit());
	}

	private Iterable<SubjectLocationDTO> callREST(Filter filter, int limit) {
		return null;
	}
}
