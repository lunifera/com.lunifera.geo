package com.lunifera.geo.jgeohash.provider.test;

import org.junit.Test;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.lunifera.geo.api.Geo;
import com.lunifera.geo.api.dto.DistanceDTO;
import com.lunifera.geo.api.dto.PositionDTO;
import com.lunifera.geo.api.dto.Unit;

import junit.framework.TestCase;

public class JgeohashImplTest extends TestCase {

	private static final String GEOHASH = "e5e6qzr5318s";

	@Test
	public void testPositionDto() throws InterruptedException {
		Geo geo = getService(Geo.class);
		PositionDTO dto = geo.getPosition(20.1234, -40.1234);
		assertEquals(20.1234, dto.latitude);
		assertEquals(-40.1234, dto.longitude);
		assertEquals(GEOHASH, dto.geoHash);
	}
	
	@Test
	public void testPositionDto2() throws InterruptedException {
		Geo geo = getService(Geo.class);
		PositionDTO dto = geo.getPosition(GEOHASH);
		assertEquals(20.123399, dto.latitude);
		assertEquals(-40.123399, dto.longitude);
		assertEquals(GEOHASH, dto.geoHash);
	}
	
	@Test
	public void testDistanceDto() throws InterruptedException {
		Geo geo = getService(Geo.class);
		PositionDTO pos1 = geo.getPosition(20.1234, -40.1234);
		PositionDTO pos2 = geo.getPosition(21.1234, -41.1234);
		DistanceDTO dto = geo.getDistance(pos1, pos2, Unit.KILOMETER);
		assertEquals(152.2892921001318, dto.distance);
		assertEquals(Unit.KILOMETER, dto.distanceUnit);
		assertEquals(pos1, dto.from);
		assertEquals(pos2, dto.to);
	}

	<T> T getService(Class<T> clazz) throws InterruptedException {
		ServiceTracker<T, T> st = new ServiceTracker<>(FrameworkUtil.getBundle(getClass()).getBundleContext(), clazz,
				null);
		st.open();
		return st.waitForService(1000);
	}
}
