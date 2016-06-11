package com.lunifera.geo.store.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.lunifera.geo.api.dto.PositionDTO;

/**
 * A 1-dimensional geometry defining a line based on given points.
 */
public class FreeLineGeometryDTO extends LineGeometryDTO {

	/**
	 * Points in the order they are connected to each other. First and last
	 * point will not become connected to each other.
	 */
	public List<PositionDTO> points = new ArrayList<>();

}
