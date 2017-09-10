package com.biscuit.soap.product.service;

import java.util.List;

import javax.jws.WebService;

import com.biscuit.soap.product.exception.ProductServiceFault;
import com.biscuit.soap.product.types.BiscuitDetails;
import com.biscuit.soap.product.types.BiscuitIdentity;
import com.biscuit.soap.product.types.BiscuitName;
import com.biscuit.soap.product.types.BiscuitType;
import com.biscuit.soap.product.types.BrandName;
import com.biscuit.soap.product.types.BrandStock;
import com.biscuit.soap.product.types.ProductDetails;
import com.biscuit.soap.product.types.ProductIdentity;
import com.biscuit.soap.product.types.ProductMarket;
import com.biscuit.soap.product.types.ProductMarketRate;
import com.biscuit.soap.product.types.ProductName;
import com.biscuit.soap.product.types.ProductType;
import com.biscuit.soap.product.types.ProductValuationDetails;
import com.biscuit.soap.product.types.ProductValue;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

@WebService(name = "ProductService", targetNamespace = "http://service.product.soap.biscuit.com/")
public interface ProductService {

	// WSDL 1 (service methods : 2)
	public ProductDetails getProductDetailByProId(ProductIdentity proId)
			throws ProductServiceFault;

	public List<ProductValuationDetails> getAllProductValuation(
			ProductValue proValue) throws ProductServiceFault;

	// WSDL 2 (service methods : 3)
	public ProductName getProductName(ProductIdentity proId)
			throws ProductServiceFault;

	public ProductType getProductType(ProductIdentity proId)
			throws ProductServiceFault;

	public ProductMarketRate getProductMarketRate(ProductIdentity proId)
			throws ProductServiceFault;

	// WSDL 3 (service methods : 2)
	public BiscuitDetails getBiscuitDetailsById(BiscuitIdentity bisId)
			throws ProductServiceFault;

	public List<BrandName> getBiscuitByBrandType(BiscuitName bisName)
			throws ProductServiceFault;

	// WSDL 4 (service methods : 2)
	public BrandStock getBiscuitByStock(BiscuitIdentity bisId)
			throws ProductServiceFault;

	public List<BiscuitType> getAllBrandBiscuitTypeBySeason(String season)
			throws ProductServiceFault;

	// WSDL 5 (service methods : 5)
	public List<BiscuitType> getAllBrandEverGreenBiscuit(BiscuitName bisName)
			throws ProductServiceFault;

	public String insertNewBrandBiscuit(BiscuitDetails biscuitDetails)
			throws ProductServiceFault;

	public String insertNewProductDetail(ProductDetails productDetails)
			throws ProductServiceFault;

	public String updateProductMarketValue(ProductMarket productMarket)
			throws ProductServiceFault;

	public String deleteProductFromCurrent(ProductIdentity proId)
			throws ProductServiceFault;

}
