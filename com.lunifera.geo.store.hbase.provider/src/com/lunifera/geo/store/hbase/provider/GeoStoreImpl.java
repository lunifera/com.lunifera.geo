package com.lunifera.geo.store.hbase.provider;

import java.io.IOException;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.osgi.namespace.implementation.ImplementationNamespace;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

import com.lunifera.geo.store.api.GeoStore;
import com.lunifera.geo.store.api.dto.SubjectLocationDTO;
import com.lunifera.geo.store.api.query.Filter;
import com.lunifera.geo.store.api.query.Query;
import com.lunifera.geo.store.api.query.QueryBuilder;

import aQute.bnd.annotation.headers.ProvideCapability;
import aQute.bnd.annotation.metatype.Meta;
import osgi.enroute.configurer.api.RequireConfigurerExtender;

/**
 * Implementation for the geo store based on hbase.
 */
@RequireConfigurerExtender
@ProvideCapability(ns = ImplementationNamespace.IMPLEMENTATION_NAMESPACE, name = GeoStoreConstants.SPECIFICATION_NAME, version = GeoStoreConstants.SPECIFICATION_VERSION)
@Component(name = "com.lunifera.geo.store.hbase", property = { "storetype=hbase", "service.pid="
		+ GeoStoreConstants.PID }, configurationPolicy = ConfigurationPolicy.REQUIRE, configurationPid = GeoStoreConstants.PID)
public class GeoStoreImpl extends Configured implements GeoStore {

	private static final String HBASE_ZOOKEEPER_CLIENTPORT = "hbase.zookeeper.clientport";
	private static final String HBASE_ZOOKEEPER_QUORUM = "hbase.zookeeper.quorum";

	@Meta.OCD(description = "Configure Access to hbase")
	@interface ClientConfiguration {
		@Meta.AD(description = "Zookeeper URL", deflt = "localhost", required = true)
		String zookeeperUrl() default "localhost";

		@Meta.AD(description = "Zookeeper Port", deflt = "2181", required = true)
		int zookeeperPort() default 2181;

		@Meta.AD(description = "Maximum records to be returned", deflt = "100", min = "1", required = true)
		int limit() default 100;
	}

	@Reference
	private LogService logger;

	private String zookeeperURL;
	private int zookeeperPort;
	private Configuration conf;
	private Connection connection;

	@Override
	public QueryBuilder createBuilder(Map<Object, Object> properties) {
		return new QueryBuilderImpl();
	}

	@Override
	public Iterable<SubjectLocationDTO> query(Query query) {
		Filter filter = query.getFilter();

		return callHbase(filter, query.getLimit());
	}

	private Iterable<SubjectLocationDTO> callHbase(Filter filter, int limit) {
		return null;
	}

	@Activate
	protected void activate(ClientConfiguration config) throws IOException {

		zookeeperURL = config.zookeeperUrl();
		zookeeperPort = config.zookeeperPort();

		try {
			createConnection();
		} catch (IOException e) {
			logger.log(LogService.LOG_WARNING, e.toString());
			throw e;
		}
	}

	@Modified
	protected void modified(ClientConfiguration config) throws IOException {
		deactivate();
		activate(config);
	}

	/**
	 * Creates a connection to the zookeeper server and hbase database.
	 * 
	 * @throws IOException
	 */
	void createConnection() throws IOException {
		conf = HBaseConfiguration.create();
		conf.set(HBASE_ZOOKEEPER_QUORUM, zookeeperURL);
		conf.setInt(HBASE_ZOOKEEPER_CLIENTPORT, zookeeperPort);
		setConf(HBaseConfiguration.create(conf));
		connection = ConnectionFactory.createConnection(conf);
	}

	@Deactivate
	protected void deactivate() {
		if (connection != null) {
			try {
				connection.close();
			} catch (IOException e) {
				logger.log(LogService.LOG_WARNING, e.toString());
			}
			connection = null;
			conf = null;
		}
	}

}
