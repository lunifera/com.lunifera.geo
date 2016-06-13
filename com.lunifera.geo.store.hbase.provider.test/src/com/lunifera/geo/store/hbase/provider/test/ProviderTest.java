package com.lunifera.geo.store.hbase.provider.test;

import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.lunifera.geo.store.api.GeoStore;
import com.lunifera.geo.store.api.query.QueryBuilder;

/**
 * 
 */

public class ProviderTest {

	private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

	/*
	 * 
	 */
	@Test
	public void testProvider() throws Exception {
		Assert.assertNotNull(context);

		GeoStore store = null;
		QueryBuilder b = store.createBuilder(null);
		store.query(b.build(null));

	}
}
