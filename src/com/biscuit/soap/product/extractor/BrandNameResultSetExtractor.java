package com.biscuit.soap.product.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.soap.product.types.BrandName;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class BrandNameResultSetExtractor implements
		ResultSetExtractor<List<BrandName>> {

	public List<BrandName> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<BrandName> brandNameList = new ArrayList<BrandName>();

		while (rs.next()) {

			BrandName brandNameObj = new BrandName();
			brandNameObj.setBiscuitType(rs.getString("BiscuitType"));
			brandNameObj.setBiscuitBrand(rs.getString("BiscuitBrand"));
			brandNameList.add(brandNameObj);
		}

		return brandNameList;
	}

}
