package com.biscuit.soap.product.validation;

import org.apache.commons.lang.StringUtils;

import com.biscuit.soap.product.exception.ProductException;
import com.biscuit.soap.product.types.ProductDetails;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductDetailsValidation {

	public static void validateProductDetails(ProductDetails proDetails)
			throws ProductException {

		if (proDetails.getId() < 1) {
			throw new ProductException("PRODUCT-31554",
					"Validation Error: Product Id is not valid.");
		}

		if (StringUtils.isBlank(proDetails.getProductName())
				|| proDetails.getProductName().length() == 0) {
			throw new ProductException("PRODUCT-31566",
					"Validation Error: Product Name is not valid.");
		}

		if (StringUtils.isBlank(proDetails.getProductType())) {
			throw new ProductException("PRODUCT-31567",
					"Validation Error: Product Type is not valid.");
		}

		if (StringUtils.isBlank(proDetails.getProductValue())
				|| StringUtils.isBlank(proDetails.getMarketValue())) {
			throw new ProductException("PRODUCT-31568",
					"Validation Error: Product Valuation is not valid.");
		}

	}
}
