package com.biscuit.soap.product.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.soap.product.types.ProductDetails;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductConfigResultSetExtractor implements
		ResultSetExtractor<List<ProductDetails>> {

	public List<ProductDetails> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<ProductDetails> productDetailList = new ArrayList<ProductDetails>();

		while (rs.next()) {

			ProductDetails productDetails = new ProductDetails();
			productDetails.setId(rs.getInt("ID"));
			productDetails.setProductName(rs.getString("ProductName"));
			productDetails.setProductType(rs.getString("ProductType"));
			productDetails.setProductValue(rs.getString("ProductValue"));
			productDetails.setMarketValue(rs.getString("MarketValue"));
			productDetailList.add(productDetails);
		}

		return productDetailList;
	}

}
