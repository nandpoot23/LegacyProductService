package com.biscuit.soap.product.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.soap.product.types.BiscuitType;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class BiscuitSeasonResultSetExtractor implements
		ResultSetExtractor<List<BiscuitType>> {

	public List<BiscuitType> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<BiscuitType> biscuitTypeList = new ArrayList<BiscuitType>();

		while (rs.next()) {

			BiscuitType biscuitTypeObj = new BiscuitType();
			biscuitTypeObj.setBiscuitName(rs.getString("BiscuitName"));
			biscuitTypeObj.setBiscuitType(rs.getString("BiscuitType"));
			biscuitTypeList.add(biscuitTypeObj);
		}

		return biscuitTypeList;
	}

}
