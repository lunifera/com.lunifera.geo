package com.lunifera.geo.store.hbase.provider;

public interface GeoStoreConstants extends com.lunifera.geo.store.api.GeoStoreConstants {

	/**
	 * The column family used for the geo data.
	 */
	String COL_FAMILY = "geo";

	/**
	 * The column name for the subjectId
	 */
	String COL_SUBJECT_ID = "subjectId";

	/**
	 * The column name for the timestamp
	 */
	String COL_TIMESTAMP = "timestamp";

	
	/**
	 * The PID to be stored with the OSGi service.
	 */
	String PID = "com.lunifera.geo.store.hbase";
}
