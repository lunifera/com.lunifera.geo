package com.lunifera.geo.store.hbase.provider;

import java.util.ServiceLoader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {


	@SuppressWarnings("unused")
	@Override
	public void start(BundleContext context) throws Exception {
		Object l = ServiceLoader.load(DocumentBuilderFactory.class);
	}

	@Override
	public void stop(BundleContext context) throws Exception {

	}

}
