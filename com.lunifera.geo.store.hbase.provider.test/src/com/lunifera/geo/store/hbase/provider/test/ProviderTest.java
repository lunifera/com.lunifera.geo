package com.lunifera.geo.store.hbase.provider.test;

import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.lunifera.geo.store.api.GeoStore;
import com.lunifera.geo.store.api.RequireGeoStoreImplementation;
import com.lunifera.geo.store.api.query.QueryBuilder;

/**
 * 
 */
@RequireGeoStoreImplementation
public class ProviderTest {

	private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

	/*
	 * 
	 */
	@Test
	public void testProvider() throws Exception {
		Assert.assertNotNull(context);

		GeoStore store = getService(GeoStore.class);
		QueryBuilder b = store.createBuilder(null);
		store.query(b.build(null));

	}
	
	<T> T getService(Class<T> clazz) throws InterruptedException {
		ServiceTracker<T, T> st = new ServiceTracker<>(FrameworkUtil.getBundle(getClass()).getBundleContext(), clazz,
				null);
		st.open();
		return st.waitForService(1000);
	}
}
