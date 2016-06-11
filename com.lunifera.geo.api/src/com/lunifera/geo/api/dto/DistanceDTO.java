package com.lunifera.geo.api.dto;

import org.osgi.dto.DTO;

/**
 * This dto keeps the distance of two positions in the defined unit.
 */
public class DistanceDTO extends DTO {

	/**
	 * The position the distance is calculated from.
	 */
	public PositionDTO from;

	/**
	 * The position the distance is calculated to.
	 */
	public PositionDTO to;

	/**
	 * The distance.
	 */
	public double distance;

	/**
	 * The unit of the distance.
	 */
	public Unit distanceUnit;

}
