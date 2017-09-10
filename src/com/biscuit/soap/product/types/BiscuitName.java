package com.biscuit.soap.product.types;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class BiscuitName {

	private String biscuitName;

	public String getBiscuitName() {
		return biscuitName;
	}

	public void setBiscuitName(String biscuitName) {
		this.biscuitName = biscuitName;
	}

	@Override
	public String toString() {
		return "BiscuitName [biscuitName=" + biscuitName + "]";
	}

}
