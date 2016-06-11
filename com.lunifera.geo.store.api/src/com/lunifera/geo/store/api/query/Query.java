package com.lunifera.geo.store.api.query;

import com.lunifera.geo.store.api.dto.SubjectLocationDTO;

/**
 * An service defining API to prepare a query to retrieve {@link SubjectLocationDTO
 * LocationDTOs}.
 */
public interface Query {

	Filter getFilter();

	void setLimit(int limit);

	int getLimit();

}
