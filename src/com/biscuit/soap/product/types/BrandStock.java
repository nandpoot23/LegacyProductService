package com.biscuit.soap.product.types;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class BrandStock {

	private String biscuitStock;
	private String biscuitBrand;

	public String getBiscuitStock() {
		return biscuitStock;
	}

	public void setBiscuitStock(String biscuitStock) {
		this.biscuitStock = biscuitStock;
	}

	public String getBiscuitBrand() {
		return biscuitBrand;
	}

	public void setBiscuitBrand(String biscuitBrand) {
		this.biscuitBrand = biscuitBrand;
	}

	@Override
	public String toString() {
		return "BrandStock [biscuitStock=" + biscuitStock + ", biscuitBrand="
				+ biscuitBrand + "]";
	}

}
