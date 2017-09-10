package com.biscuit.soap.product.validation;

import org.apache.commons.lang.StringUtils;

import com.biscuit.soap.product.exception.BiscuitException;
import com.biscuit.soap.product.types.BiscuitDetails;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class BiscuitDetailsValidation {

	public static void validateProductDetails(BiscuitDetails bisDetails)
			throws BiscuitException {

		if (bisDetails.getBiscuitId() < 1) {
			throw new BiscuitException("BISCUIT-51554",
					"Validation Error: Biscuit Id is not valid.");
		}

		if (StringUtils.isBlank(bisDetails.getBiscuitName())
				|| bisDetails.getBiscuitName().length() == 0) {
			throw new BiscuitException("BISCUIT-51568",
					"Validation Error: Biscuit Name is not valid.");
		}

		if (StringUtils.isBlank(bisDetails.getBiscuitType())) {
			throw new BiscuitException("BISCUIT-51569",
					"Validation Error: Biscuit Type is not valid.");
		}

		if (StringUtils.isBlank(bisDetails.getBiscuitStock())
				|| StringUtils.isBlank(bisDetails.getBiscuitBrandName())) {
			throw new BiscuitException("BISCUIT-51570",
					"Validation Error: Biscuit Stock with Brand is not valid.");
		}

	}
}
