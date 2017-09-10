package com.biscuit.soap.product.exception;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class BiscuitException extends ProductServiceFault {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BiscuitException(String code, String msg) {
		super(code, msg);
	}
}
