package com.lunifera.wrapping.hbase.client.provider.test;

import javax.crypto.interfaces.DHKey;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ProviderTest extends Configured {

	private static final String ZOOKEEPER_URL = "136.243.111.213";
	private static final int ZOOKEEPER_PORT = 2181;
	private static final TableName TABLE_NAME = TableName.valueOf("test");
	//
	private static Configuration conf = null;
	private static Connection connection;
	private Table table;

	private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

	/*
	 * 
	 */
	@Test
	public void testConnection() throws Exception {

		FrameworkUtil.getBundle(getClass());
		
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", ZOOKEEPER_URL);
		conf.setInt("hbase.zookeeper.clientport", ZOOKEEPER_PORT);
		setConf(HBaseConfiguration.create(conf));

		try {
			connection = ConnectionFactory.createConnection(conf);
			table = connection.getTable(TABLE_NAME);

			Get g = new Get(Bytes.toBytes("44"));
//			g.setTimeRange(1465394530064L, 1465563179330L);
//			g.setMaxVersions();
//			Result r = table.get(g);
//			System.out.println(r);
//			byte[] value = r.getValue(Bytes.toBytes("professional data"), Bytes.toBytes("salary"));
//			System.out.println(Bytes.toString(value));

			Put p = new Put(Bytes.toBytes("44"));
			p.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("name"), Bytes.toBytes("Fuchs"));
			p.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("firstname"), Bytes.toBytes("Smirre"));
			p.addColumn(Bytes.toBytes("professional data"), Bytes.toBytes("job"), Bytes.toBytes("Endgegner"));
			p.addColumn(Bytes.toBytes("professional data"), Bytes.toBytes("salary"), Bytes.toBytes("44444"));
			table.put(p);

			Result r = table.get(g);
			System.out.println(r);
			byte[] value = r.getValue(Bytes.toBytes("professional data"), Bytes.toBytes("salary"));
			System.out.println(Bytes.toString(value));

		} finally {
			// close everything down
			if (table != null)
				table.close();
			if (connection != null)
				connection.close();
		}
	}
}
