package com.lunifera.geo.store.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.lunifera.geo.api.dto.PositionDTO;

/**
 * A 2-dimensional geometry defining an area based on given points. Last point
 * in the list will connect to first point in the list.
 */
public class FreeAreaGeometryDTO extends AreaGeometryDTO {

	/**
	 * Points in the order they are connected to each other. Last point in the
	 * list will connect to first point in the list.
	 */
	public List<PositionDTO> points = new ArrayList<>();

}
