package com.lunifera.geo.api;

import java.util.Collection;
import java.util.List;

import com.lunifera.geo.api.dto.DistanceDTO;
import com.lunifera.geo.api.dto.PositionDTO;
import com.lunifera.geo.api.dto.Unit;

/**
 * 
 */
public interface Geo {

	/**
	 * Returns the position for the given latitude and longitude.
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	PositionDTO getPosition(double latitude, double longitude);

	/**
	 * Returns the position for the given geoHash.
	 * 
	 * @param geoHash
	 * @return
	 */
	PositionDTO getPosition(String geoHash);

	/**
	 * Returns the distance for the given from and to converted to the
	 * distanceUnit.
	 * 
	 * @param from
	 * @param to
	 * @param distanceUnit
	 * @return
	 */
	DistanceDTO getDistance(PositionDTO from, PositionDTO to, Unit distanceUnit);

	/**
	 * Returns the distance for the given from and to geoHashes converted to the
	 * distanceUnit.
	 * 
	 * @param geoHashFrom
	 * @param geoHashTo
	 * @param distanceUnit
	 * @return
	 */
	DistanceDTO getDistance(String geoHashFrom, String geoHashTo, Unit distanceUnit);

	/**
	 * Returns the all distances for the given from and to positions converted
	 * to the distanceUnit.
	 * 
	 * @param from
	 * @param to
	 * @param distanceUnit
	 * @return
	 */
	List<DistanceDTO> getDistances(PositionDTO from, Collection<PositionDTO> to, Unit distanceUnit);

}
