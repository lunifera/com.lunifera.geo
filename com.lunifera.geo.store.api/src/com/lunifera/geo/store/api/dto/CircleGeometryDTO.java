package com.lunifera.geo.store.api.dto;

import com.lunifera.geo.api.dto.PositionDTO;

/**
 * A 2-dimensional geometry defining a circle.
 */
public class CircleGeometryDTO extends AreaGeometryDTO {

	/**
	 * This point defines the center of the circle.
	 */
	public PositionDTO center;

	/**
	 * Defines the radius of the circle.
	 */
	public long radius;

}
