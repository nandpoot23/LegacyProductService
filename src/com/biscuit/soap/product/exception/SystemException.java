package com.biscuit.soap.product.exception;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class SystemException extends ProductServiceFault {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemException(String code, String message) {
		super(code, message);
	}

}
