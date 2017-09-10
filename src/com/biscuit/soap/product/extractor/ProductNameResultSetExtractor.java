package com.biscuit.soap.product.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.soap.product.types.ProductName;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductNameResultSetExtractor implements
		ResultSetExtractor<List<ProductName>> {

	public List<ProductName> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<ProductName> productNameList = new ArrayList<ProductName>();

		while (rs.next()) {

			ProductName productName = new ProductName();

			productName.setProductName(rs.getString("ProductName"));
			productNameList.add(productName);
		}

		return productNameList;
	}

}
