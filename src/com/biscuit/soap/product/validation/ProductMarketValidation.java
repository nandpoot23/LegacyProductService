package com.biscuit.soap.product.validation;

import org.apache.commons.lang.StringUtils;

import com.biscuit.soap.product.exception.ProductException;
import com.biscuit.soap.product.types.ProductMarket;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductMarketValidation {

	public static void validateProductMarket(ProductMarket proMarket)
			throws ProductException {

		if (proMarket.getProductId() < 1) {
			throw new ProductException("PRODUCT-31554",
					"Validation Error: Product Id is not valid.");
		}

		if (StringUtils.isBlank(proMarket.getProductValue())
				|| StringUtils.isBlank(proMarket.getMarketValue())) {
			throw new ProductException("PRODUCT-31568",
					"Validation Error: Product Valuation is not valid.");
		}

	}

}
