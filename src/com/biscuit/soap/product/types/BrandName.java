package com.biscuit.soap.product.types;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class BrandName {

	private String biscuitBrand;
	private String biscuitType;

	public String getBiscuitBrand() {
		return biscuitBrand;
	}

	public void setBiscuitBrand(String biscuitBrand) {
		this.biscuitBrand = biscuitBrand;
	}

	public String getBiscuitType() {
		return biscuitType;
	}

	public void setBiscuitType(String biscuitType) {
		this.biscuitType = biscuitType;
	}

	@Override
	public String toString() {
		return "BrandName [biscuitBrand=" + biscuitBrand + ", biscuitType="
				+ biscuitType + "]";
	}

}
