package com.biscuit.soap.product.types;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductMarket {

	private int productId;
	private String productValue;
	private String marketValue;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
		return "ProductMarket [productId=" + productId + ", productValue="
				+ productValue + ", marketValue=" + marketValue + "]";
	}

}
