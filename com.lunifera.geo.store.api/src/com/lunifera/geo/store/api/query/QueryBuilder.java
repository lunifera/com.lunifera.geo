package com.lunifera.geo.store.api.query;

import java.time.LocalDateTime;

import com.lunifera.geo.store.api.GeoStore;
import com.lunifera.geo.store.api.dto.AreaGeometryDTO;
import com.lunifera.geo.store.api.dto.LineGeometryDTO;
import com.lunifera.geo.store.api.dto.SubjectLocationDTO;

/**
 * Builds a query to be used with the {@link GeoStore Geo service} to find all proper
 * {@link SubjectLocationDTO locations}.
 */
public interface QueryBuilder {

	/**
	 * Filters the given attribute.
	 * 
	 * @param field
	 * @param compareType
	 * @param value
	 * @return
	 */
	FieldFilter filter(String field, CompareType compareType, Object value);

	/**
	 * Filters the timestamp.
	 * 
	 * @param timestamp
	 * @param value
	 * @return
	 */
	FieldFilter timestamp(CompareType compareType, LocalDateTime timestamp);

	/**
	 * Filters the subjectId.
	 * 
	 * @param compareType
	 * @param subjectId
	 * @return
	 */
	FieldFilter subjectId(CompareType compareType, String subjectId);

	/**
	 * Adds a filter to the query matching all locactions that are inside the
	 * given area.
	 * 
	 * @param within
	 * @return
	 */
	WithinFilter within(AreaGeometryDTO within);

	/**
	 * Adds a filter to the query matching all locactions that are intersecting
	 * the given line.
	 * 
	 * @param intersects
	 * @return
	 */
	IntersectsFilter intersects(LineGeometryDTO intersects);

	/**
	 * An or filter.
	 * 
	 * @return
	 */
	OrFilter or(Filter... filters);

	/**
	 * An and filter.
	 * 
	 * @return
	 */
	AndFilter and(Filter... filters);

	/**
	 * A not filter.
	 * 
	 * @return
	 */
	NotFilter not(Filter filter);

	/**
	 * Returns the query for the given filter.
	 * 
	 * @return
	 */
	Query build(Filter filter);

	public enum CompareType {
		EQUALS, GREATER, LOWER, LOWER_EQUAL, GREATER_EQUAL, NOT_EQUAL
	}

}
