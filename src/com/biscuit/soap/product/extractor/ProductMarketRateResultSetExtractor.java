package com.biscuit.soap.product.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.soap.product.types.ProductMarketRate;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductMarketRateResultSetExtractor implements
		ResultSetExtractor<List<ProductMarketRate>> {

	public List<ProductMarketRate> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<ProductMarketRate> productMarketRateList = new ArrayList<ProductMarketRate>();

		while (rs.next()) {

			ProductMarketRate productMarketRate = new ProductMarketRate();

			productMarketRate.setProdMarketRate(rs.getString("MarketValue"));
			productMarketRateList.add(productMarketRate);
		}

		return productMarketRateList;
	}

}
