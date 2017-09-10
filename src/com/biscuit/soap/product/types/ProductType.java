package com.biscuit.soap.product.types;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class ProductType {

	private String productType;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "ProductType [productType=" + productType + "]";
	}

}
