package com.biscuit.soap.product.types;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

public class BiscuitIdentity {

	private String biscuitId;

	public String getBiscuitId() {
		return biscuitId;
	}

	public void setBiscuitId(String biscuitId) {
		this.biscuitId = biscuitId;
	}

	@Override
	public String toString() {
		return "BiscuitIdentity [biscuitId=" + biscuitId + "]";
	}

}
