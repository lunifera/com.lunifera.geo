package com.lunifera.geo.api.dto;

import org.osgi.dto.DTO;

/**
 * This dto keeps the latitude, longitude and the geoHash.
 */
public class PositionDTO extends DTO {

	/**
	 * The geo hash calculated from {@link #latitude} and {@link #longitude}.
	 */
	public String geoHash;

	/**
	 * The latitude.
	 */
	public double latitude;

	/**
	 * The longitude.
	 */
	public double longitude;

}
