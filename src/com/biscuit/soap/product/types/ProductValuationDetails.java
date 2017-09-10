package com.biscuit.soap.product.types;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductValuationDetails {

	private String productName;
	private String productValue;
	private String marketValue;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductValue() {
		return productValue;
	}

	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}

	public String getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}

	@Override
	public String toString() {
		return "ProductValuationDetails [productName=" + productName
				+ ", productValue=" + productValue + ", marketValue="
				+ marketValue + "]";
	}

}
