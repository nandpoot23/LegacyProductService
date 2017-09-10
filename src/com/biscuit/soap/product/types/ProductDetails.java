package com.biscuit.soap.product.types;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductDetails {

	private int id;
	private String productName;
	private String productType;
	private String productValue;
	private String marketValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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
		return "ProductDetails [id=" + id + ", productName=" + productName
				+ ", productType=" + productType + ", productValue="
				+ productValue + ", marketValue=" + marketValue + "]";
	}

}
