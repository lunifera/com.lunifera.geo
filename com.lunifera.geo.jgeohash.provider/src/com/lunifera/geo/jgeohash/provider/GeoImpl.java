package com.lunifera.geo.jgeohash.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osgi.namespace.implementation.ImplementationNamespace;
import org.osgi.service.component.annotations.Component;

import com.lunifera.geo.api.Geo;
import com.lunifera.geo.api.GeoConstants;
import com.lunifera.geo.api.dto.DistanceDTO;
import com.lunifera.geo.api.dto.PositionDTO;
import com.lunifera.geo.api.dto.Unit;

import aQute.bnd.annotation.headers.ProvideCapability;
import de.alpharogroup.jgeohash.GeoHashExtensions;
import de.alpharogroup.jgeohash.distance.DistanceCalculator;
import de.alpharogroup.jgeohash.distance.MeasuringUnit;

/**
 * 
 */
@ProvideCapability(ns = ImplementationNamespace.IMPLEMENTATION_NAMESPACE, name = GeoConstants.SPECIFICATION_NAME, version = GeoConstants.SPECIFICATION_VERSION)
@Component(name = "com.lunifera.geo.jgeohash", property = "impl=jgeohash")
public class GeoImpl implements Geo {

	@Override
	public PositionDTO getPosition(double latitude, double longitude) {
		PositionDTO dto = new PositionDTO();
		dto.latitude = latitude;
		dto.longitude = longitude;
		dto.geoHash = GeoHashExtensions.encode(latitude, longitude);

		return dto;
	}

	@Override
	public PositionDTO getPosition(String geoHash) {
		double[] decoded = GeoHashExtensions.decodeAndRound(geoHash);
		PositionDTO dto = new PositionDTO();
		dto.latitude = decoded[0];
		dto.longitude = decoded[1];
		dto.geoHash = geoHash;
		return dto;

	}

	@Override
	public DistanceDTO getDistance(PositionDTO from, PositionDTO to, Unit distanceUnit) {
		double distance = DistanceCalculator.distanceBetweenPoints(new PositionCustom(from), new PositionCustom(to),
				toUnit(distanceUnit));

		DistanceDTO result = new DistanceDTO();
		result.from = from;
		result.to = to;
		result.distance = distance;
		result.distanceUnit = distanceUnit;

		return result;
	}

	@Override
	public DistanceDTO getDistance(String geoHashFrom, String geoHashTo, Unit distanceUnit) {
		return getDistance(getPosition(geoHashFrom), getPosition(geoHashTo), distanceUnit);
	}

//	@Override
//	public DistanceDTO getShortedDistance(PositionDTO from, Collection<PositionDTO> to, Unit distanceUnit) {
//		return null;
//	}
//
//	@Override
//	public DistanceDTO getLongestDistance(PositionDTO from, Collection<PositionDTO> to, Unit distanceUnit) {
//		return null;
//	}

	@Override
	public List<DistanceDTO> getDistances(PositionDTO from, Collection<PositionDTO> to, Unit distanceUnit) {
		
		List<DistanceDTO> result = new ArrayList<>();
		for(PositionDTO x : to) {
			result.add(getDistance(from, x, distanceUnit));
		}
		
		return result;
	}

	static MeasuringUnit toUnit(Unit distanceUnit) {
		switch (distanceUnit) {
		case KILOMETER:
			return MeasuringUnit.KILOMETER;
		case METER:
			return MeasuringUnit.METER;
		case MILE:
			return MeasuringUnit.MILE;
		}
		return null;
	}

	static Unit toMeasuringUnit(MeasuringUnit distanceUnit) {
		switch (distanceUnit) {
		case KILOMETER:
			return Unit.KILOMETER;
		case METER:
			return Unit.METER;
		case MILE:
			return Unit.MILE;
		}
		return null;
	}

}
