package com.biscuit.soap.product.validation;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class NumericValidation {

	/**
	 * Returns whether a string consists of all numeric digits.
	 *
	 */
	public static boolean isAlfaNumeric(String number) {
		if (number != null && number.matches("\\d+")) {
			return false;
		}
		return true;
	}

}
