package com.lunifera.geo.jgeohash.provider;

import com.lunifera.geo.api.dto.PositionDTO;

import de.alpharogroup.jgeohash.GeoHashPoint;

/**
 * Custom 
 */
@SuppressWarnings("serial")
public class PositionCustom extends GeoHashPoint {

	public PositionCustom(double latitude, double longitude) {
		super(latitude, longitude);
	}

	public PositionCustom(String geohash) {
		super(geohash);
	}

	public PositionCustom(PositionDTO position) {
		super(position.latitude, position.longitude);
	}

}
