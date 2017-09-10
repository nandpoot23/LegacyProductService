package com.biscuit.soap.product.connection;

import java.sql.SQLException;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductDataConfig {

	public static SimpleDriverDataSource getDataSource() throws SQLException {

		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/springboot");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
}
