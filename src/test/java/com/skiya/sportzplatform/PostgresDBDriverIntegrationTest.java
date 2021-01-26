package com.skiya.sportzplatform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PostgresDBDriverIntegrationTest {

	private static final Logger logger = LoggerFactory.getLogger(PostgresDBDriverIntegrationTest.class);

	@Test	
	public void testDatabaseConnection() throws SQLException {
		PGSimpleDataSource pgds = new PGSimpleDataSource();
		pgds.setUser("postgres");
		pgds.setUrl("jdbc:postgresql://localhost:5432/sportzplatform");
		pgds.setPassword("password");
		pgds.setApplicationName("sportzplatform");		
		try (Connection conn = pgds.getConnection();
				Statement statement = conn.createStatement();) {
			logger.info("Statement Fetch Size {}", statement.getFetchSize());
			try (ResultSet results = statement.executeQuery("select * from lookup_type");) {
				ResultSetMetaData metaData = results.getMetaData();
				int columnCount = metaData.getColumnCount();
				logger.info("Total columns {}", columnCount);
				for (int i = 1; i <= columnCount; i++) {
					logger.info("Column {} ", metaData.getColumnName(i));
				}

				while (results.next()) {
					logger.info("Row read");
				}
			}
		}
	}

}
