package com.biscuit.soap.product.types;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class BiscuitDetails {

	private int biscuitId;
	private String biscuitName;
	private String biscuitType;
	private String biscuitStock;
	private String biscuitBrandName;

	public int getBiscuitId() {
		return biscuitId;
	}

	public void setBiscuitId(int biscuitId) {
		this.biscuitId = biscuitId;
	}

	public String getBiscuitName() {
		return biscuitName;
	}

	public void setBiscuitName(String biscuitName) {
		this.biscuitName = biscuitName;
	}

	public String getBiscuitType() {
		return biscuitType;
	}

	public void setBiscuitType(String biscuitType) {
		this.biscuitType = biscuitType;
	}

	public String getBiscuitStock() {
		return biscuitStock;
	}

	public void setBiscuitStock(String biscuitStock) {
		this.biscuitStock = biscuitStock;
	}

	public String getBiscuitBrandName() {
		return biscuitBrandName;
	}

	public void setBiscuitBrandName(String biscuitBrandName) {
		this.biscuitBrandName = biscuitBrandName;
	}

	@Override
	public String toString() {
		return "BiscuitDetails [biscuitId=" + biscuitId + ", biscuitName="
				+ biscuitName + ", biscuitType=" + biscuitType
				+ ", biscuitStock=" + biscuitStock + ", biscuitBrandName="
				+ biscuitBrandName + "]";
	}

}
