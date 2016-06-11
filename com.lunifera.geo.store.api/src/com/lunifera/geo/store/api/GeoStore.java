package com.lunifera.geo.store.api;

import java.util.Map;

import com.lunifera.geo.store.api.dto.SubjectLocationDTO;
import com.lunifera.geo.store.api.query.Query;
import com.lunifera.geo.store.api.query.QueryBuilder;

/**
 * Service to get geo locations for a given subjectId, time interval and fence.
 */
public interface GeoStore {

	/**
	 * Defines the type of the store. For instance HBase, MongoDB,...
	 */
	public static final String PROP_STORE_TYPE = "storetype";

	/**
	 * Returns a proper {@link QueryBuilder} for the given properties.
	 * 
	 * @param properties
	 * @return
	 */
	QueryBuilder createBuilder(Map<Object, Object> properties);

	/**
	 * Returns an iterable with all location dtos selected by the given query.
	 * 
	 * @param query
	 * @return
	 */
	Iterable<SubjectLocationDTO> query(Query query);

}
