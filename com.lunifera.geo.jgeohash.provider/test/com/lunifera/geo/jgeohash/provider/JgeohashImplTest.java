package com.lunifera.geo.jgeohash.provider;

import org.junit.Test;
import org.osgi.service.component.annotations.Reference;

import com.lunifera.geo.api.Geo;
import com.lunifera.geo.api.dto.PositionDTO;

import junit.framework.TestCase;

public class JgeohashImplTest extends TestCase {

	@Reference
	Geo geo;

	@Test
	public void testPositionDto() {
		PositionDTO dto = geo.getPosition(20.1234, -40.1234);
		assertEquals(20.1234, dto.latitude);
		assertEquals(-40.1234, dto.longitude);
		assertEquals("", dto.geoHash);
	}

}
