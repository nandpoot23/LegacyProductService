package com.biscuit.soap.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.biscuit.soap.product.connection.ProductDataConfig;
import com.biscuit.soap.product.exception.BiscuitException;
import com.biscuit.soap.product.exception.DatabaseException;
import com.biscuit.soap.product.exception.ProductException;
import com.biscuit.soap.product.exception.ProductServiceFault;
import com.biscuit.soap.product.exception.SystemException;
import com.biscuit.soap.product.extractor.BiscuitConfigResultSetExtractor;
import com.biscuit.soap.product.extractor.BiscuitSeasonResultSetExtractor;
import com.biscuit.soap.product.extractor.BiscuitStockResultSetExtractor;
import com.biscuit.soap.product.extractor.BrandNameResultSetExtractor;
import com.biscuit.soap.product.extractor.ProductConfigResultSetExtractor;
import com.biscuit.soap.product.extractor.ProductMarketRateResultSetExtractor;
import com.biscuit.soap.product.extractor.ProductNameResultSetExtractor;
import com.biscuit.soap.product.extractor.ProductTypeResultSetExtractor;
import com.biscuit.soap.product.extractor.ProductValuationResultSetExtractor;
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
import com.biscuit.soap.product.validation.BiscuitDetailsValidation;
import com.biscuit.soap.product.validation.NumericValidation;
import com.biscuit.soap.product.validation.ProductDetailsValidation;
import com.biscuit.soap.product.validation.ProductMarketValidation;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

@WebService(targetNamespace = "http://service.product.soap.biscuit.com/", endpointInterface = "com.biscuit.soap.product.service.ProductService", portName = "ProductServiceImplPort", serviceName = "ProductServiceImplService")
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = LoggerFactory
			.getLogger(ProductServiceImpl.class);

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.biscuit.soap.product.service.ProductService#getProductDetailByProId
	 * (com.biscuit.soap.product.types.ProductIdentity) There are three basic
	 * error mechanism if value fails in validation value paas but due to some
	 * error like connection/network traffic/down for maintenance/ crash shows
	 * db error. value paas but not exist in database.
	 */

	@Override
	public ProductDetails getProductDetailByProId(ProductIdentity proId)
			throws ProductServiceFault {

		/*
		 * Numeric validation, if 0 then exception, if -ve value exception, if
		 * string value then exception, if alphanumeric then exception only pure
		 * int value should go ahead.
		 */

		if (NumericValidation.isAlfaNumeric(proId.getProductId())
				|| Integer.parseInt(proId.getProductId()) < 1) {
			LOG.debug("please provide the valid product id");
			throw new ProductException("PRODUCT-31554",
					"Validation Error: Product Id is not valid.");
		}

		List<ProductDetails> productList = new ArrayList<ProductDetails>();

		try {
			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());
			String query = "select * from product where id = ?";
			productList = jdbcTemplate.query(query,
					new Object[] { proId.getProductId() },
					new ProductConfigResultSetExtractor());
			LOG.debug(" Query for getProductDetailByProId : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting product configuration ", e);
			throw new DatabaseException("PRODUCT-31555",
					"DB Error: An error occurred while calling product details");
		}

		if (CollectionUtils.isEmpty(productList)) {
			throw new SystemException("PRODUCT-31556",
					"System Error: Product not exist.");
		}

		return productList.get(0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.biscuit.soap.product.service.ProductService#getAllProductValuation
	 * (com.biscuit.soap.product.types.ProductValue)
	 */
	@Override
	public List<ProductValuationDetails> getAllProductValuation(
			ProductValue proValue) throws ProductServiceFault {

		if (proValue.getProValuation().isEmpty()
				|| proValue.getProValuation().length() == 0
				|| StringUtils.isBlank(proValue.getProValuation())) {
			LOG.debug("please provide the valid product id");
			throw new ProductException("PRODUCT-31557",
					"Validation Error: Please give the valid number.");
		}

		List<ProductValuationDetails> productValuationList = new ArrayList<ProductValuationDetails>();
		String query = "select ProductName, ProductValue, MarketValue from product";

		try {
			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());
			productValuationList = jdbcTemplate.query(query,
					new ProductValuationResultSetExtractor());

			LOG.debug(" Query for getAllProductValuation : " + query);
		} catch (Exception e) {
			LOG.error("Exception while getting product valuations ", e);
			throw new DatabaseException("PRODUCT-31558",
					"DB Error: An error occurred while calling product valuation");
		}

		if (CollectionUtils.isEmpty(productValuationList)) {

			throw new SystemException("PRODUCT-31559",
					"System Error: Product not in range.");
		}

		return productValuationList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.biscuit.soap.product.service.ProductService#getProductName(com.biscuit
	 * .soap.product.types.ProductIdentity)
	 */
	@Override
	public ProductName getProductName(ProductIdentity proId)
			throws ProductServiceFault {

		if (NumericValidation.isAlfaNumeric(proId.getProductId())
				|| Integer.parseInt(proId.getProductId()) < 1) {
			LOG.debug("please provide the valid product id");
			throw new ProductException("PRODUCT-31554",
					"Validation Error: Product Id is not valid.");
		}

		List<ProductName> productList = new ArrayList<ProductName>();

		try {
			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());
			String query = "select ProductName from product where id = ?";

			productList = jdbcTemplate.query(query,
					new Object[] { proId.getProductId() },
					new ProductNameResultSetExtractor());
			LOG.debug(" Query for getProductName : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("PRODUCT-31560",
					"DB Error: An error occurred while calling product name");
		}
		if (!productList.isEmpty()) {

			return productList.get(0);
		} else {
			throw new SystemException("PRODUCT-31561",
					"System Error: Product name is not available.");
		}

	}

	@Override
	public ProductType getProductType(ProductIdentity proId)
			throws ProductServiceFault {

		if (NumericValidation.isAlfaNumeric(proId.getProductId())
				|| Integer.parseInt(proId.getProductId()) < 1) {
			LOG.debug("please provide the valid product id");
			throw new ProductException("PRODUCT-31554",
					"Validation Error: Product Id is not valid.");
		}

		List<ProductType> productTypeList = new ArrayList<ProductType>();

		try {
			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());
			String query = "select ProductType from product where id = ?";

			productTypeList = jdbcTemplate.query(query,
					new Object[] { proId.getProductId() },
					new ProductTypeResultSetExtractor());
			LOG.debug(" Query for getProductType : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("PRODUCT-31562",
					"DB Error: An error occurred while calling product type");

		}
		if (!productTypeList.isEmpty()) {

			return productTypeList.get(0);
		}

		else {

			throw new SystemException("PRODUCT-31563",
					"System Error: Product type is not available.");
		}

	}

	@Override
	public ProductMarketRate getProductMarketRate(ProductIdentity proId)
			throws ProductServiceFault {

		if (NumericValidation.isAlfaNumeric(proId.getProductId())
				|| Integer.parseInt(proId.getProductId()) < 1) {
			LOG.debug("please provide the valid product id");
			throw new ProductException("PRODUCT-31554",
					"Validation Error: Product Id is not valid.");
		}

		List<ProductMarketRate> productMarketRateList = new ArrayList<ProductMarketRate>();

		try {
			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());
			String query = "select MarketValue from product where id = ?";

			productMarketRateList = jdbcTemplate.query(query,
					new Object[] { proId.getProductId() },
					new ProductMarketRateResultSetExtractor());
			LOG.debug(" Query for getProductMarketRate : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("PRODUCT-31564",
					"DB Error: An error occurred while calling product market");
		}

		if (CollectionUtils.isEmpty(productMarketRateList)) {

			throw new SystemException("PRODUCT-31565",
					"System Error: Product market is not available.");
		}

		return productMarketRateList.get(0);

	}

	@Override
	public BiscuitDetails getBiscuitDetailsById(BiscuitIdentity bisId)
			throws ProductServiceFault {

		if (NumericValidation.isAlfaNumeric(bisId.getBiscuitId())
				|| Integer.parseInt(bisId.getBiscuitId()) < 1) {
			LOG.debug("please provide the valid biscuit id");
			throw new BiscuitException("BISCUIT-51554",
					"Validation Error: Biscuit Id is not valid.");
		}

		List<BiscuitDetails> biscuitDetailsList = new ArrayList<BiscuitDetails>();

		try {

			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());

			String query = "select * from biscuit where id = ?";
			biscuitDetailsList = jdbcTemplate.query(query,
					new Object[] { bisId.getBiscuitId() },
					new BiscuitConfigResultSetExtractor());

			LOG.debug(" Query for getBiscuitDetailsById : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit configurations ", e);
			throw new DatabaseException("BISCUIT-51555",
					"DB Error: An error occurred while getting biscuit");
		}

		if (CollectionUtils.isEmpty(biscuitDetailsList)) {

			throw new SystemException("BISCUIT-51556",
					"System Error: Biscuit is not available.");
		}

		return biscuitDetailsList.get(0);
	}

	@Override
	public List<BrandName> getBiscuitByBrandType(BiscuitName bisName)
			throws ProductServiceFault {

		if (StringUtils.isBlank(bisName.getBiscuitName())) {
			LOG.debug("please provide the valid biscuit name");
			throw new BiscuitException("BISCUIT-51557",
					"Validation Error: Please give proper biscuit name.");
		}

		List<BrandName> brandNameList = new ArrayList<BrandName>();

		try {

			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());

			String query = "select BiscuitType, BiscuitBrand from biscuit where BiscuitName = ?";
			brandNameList = jdbcTemplate.query(query,
					new Object[] { bisName.getBiscuitName() },
					new BrandNameResultSetExtractor());

			LOG.debug(" Query for getBiscuitByBrandType : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit brand ", e);
			throw new DatabaseException("BISCUIT-51558",
					"DB Error: An error occurred while getting biscuit name");

		}

		if (CollectionUtils.isEmpty(brandNameList)) {

			throw new SystemException("BISCUIT-51559",
					"System Error: Biscuit name is not valid.");

		}

		return brandNameList;

	}

	@Override
	public BrandStock getBiscuitByStock(BiscuitIdentity bisId)
			throws ProductServiceFault {

		if (NumericValidation.isAlfaNumeric(bisId.getBiscuitId())
				|| Integer.parseInt(bisId.getBiscuitId()) < 1) {
			LOG.debug("please provide the valid biscuit id");
			throw new BiscuitException("BISCUIT-51554",
					"Validation Error: Biscuit Id is not valid.");
		}

		List<BrandStock> brandStockList = new ArrayList<BrandStock>();

		try {

			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());

			String query = "select BiscuitStock, BiscuitBrand from biscuit where id = ?";
			brandStockList = jdbcTemplate.query(query,
					new Object[] { bisId.getBiscuitId() },
					new BiscuitStockResultSetExtractor());

			LOG.debug(" Query for getBiscuitByStock : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit configurations ", e);
			throw new DatabaseException("BISCUIT-51560",
					"DB Error: An error occurred while getting biscuit stock");
		}

		if (CollectionUtils.isEmpty(brandStockList)) {

			throw new SystemException("BISCUIT-51561",
					"System Error: Biscuit stock is not available.");
		}

		return brandStockList.get(0);

	}

	@Override
	public List<BiscuitType> getAllBrandBiscuitTypeBySeason(String season)
			throws ProductServiceFault {

		if (StringUtils.isEmpty(season) || season.length() == 0) {
			LOG.debug("please provide the valid season name");
			throw new BiscuitException("BISCUIT-51562",
					"Validation Error: Please give correct season name.");
		}

		List<BiscuitType> biscuitTypeList = new ArrayList<BiscuitType>();

		try {

			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());

			String query = "select BiscuitName, BiscuitType from biscuit where BiscuitBrand = ?";
			biscuitTypeList = jdbcTemplate.query(query,
					new Object[] { season },
					new BiscuitSeasonResultSetExtractor());

			LOG.debug(" Query for getAllBrandBiscuitTypeBySeason : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit season ", e);
			throw new DatabaseException("BISCUIT-51563",
					"DB Error: An error occurred while getting biscuit brand");
		}

		if (CollectionUtils.isEmpty(biscuitTypeList)) {

			throw new SystemException("BISCUIT-51564",
					"System Error: Season not found.");
		}

		return biscuitTypeList;

	}

	@Override
	public List<BiscuitType> getAllBrandEverGreenBiscuit(BiscuitName bisName)
			throws ProductServiceFault {

		if (StringUtils.isBlank(bisName.getBiscuitName())
				|| bisName.getBiscuitName().length() == 0) {
			LOG.debug("please provide the valid biscuit name");
			throw new BiscuitException("BISCUIT-51565",
					"Validation Error: Please give proper biscuit name.");
		}

		List<BiscuitType> biscuitTypeList = new ArrayList<BiscuitType>();
		List<String> args = new ArrayList<String>();
		args.add(bisName.getBiscuitName());

		try {

			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());

			String query = "select BiscuitName, BiscuitType from biscuit where BiscuitName = ?";
			biscuitTypeList = jdbcTemplate.query(query, args.toArray(),
					new BiscuitSeasonResultSetExtractor());

			LOG.debug(" Query for getAllBrandEverGreenBiscuit : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit season ", e);
			throw new DatabaseException("BISCUIT-51566",
					"DB Error: An error occurred while getting evergreen biscuit");
		}

		if (biscuitTypeList.isEmpty()) {

			throw new SystemException("BISCUIT-51567",
					"System Error: Evergreen Biscuit is not available.");
		}

		return biscuitTypeList;

	}

	@Override
	public String insertNewBrandBiscuit(BiscuitDetails biscuitDetails)
			throws ProductServiceFault {

		BiscuitDetailsValidation.validateProductDetails(biscuitDetails);

		try {

			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());

			String query = "insert into biscuit(ID, BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand) "
					+ "values(?, ?, ?, ?, ?)";

			int rowInserted = jdbcTemplate.update(
					query,
					new Object[] { biscuitDetails.getBiscuitId(),
							biscuitDetails.getBiscuitName(),
							biscuitDetails.getBiscuitType(),
							biscuitDetails.getBiscuitStock(),
							biscuitDetails.getBiscuitBrandName() });

			LOG.debug(" Query for insertNewBrandBiscuit : " + query);

			if (rowInserted == 1) {
				return "record inserted.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("BISCUIT-51571",
					"DB Error: An error occurred while inserting new biscuit");
		}

		throw new SystemException("BISCUIT-51572",
				"System Error: An error occurred while inserting new biscuit");

	}

	@Override
	public String insertNewProductDetail(ProductDetails productDetails)
			throws ProductServiceFault {

		ProductDetailsValidation.validateProductDetails(productDetails);

		try {

			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());

			String query = "insert into product(ID, ProductName, ProductType, ProductValue, MarketValue) "
					+ "values(?, ?, ?, ?, ?)";

			int rowInserted = jdbcTemplate.update(
					query,
					new Object[] { productDetails.getId(),
							productDetails.getProductName(),
							productDetails.getProductType(),
							productDetails.getProductValue(),
							productDetails.getMarketValue() });

			LOG.debug(" Query for insertNewProductDetail : " + query);

			if (rowInserted == 1) {
				return "record inserted.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("PRODUCT-31569",
					"DB Error: An error occurred while inserting new product");
		}

		throw new SystemException("PRODUCT-31570",
				"System Error: An error occurred while inserting new product");
	}

	@Override
	public String updateProductMarketValue(ProductMarket productMarket)
			throws ProductServiceFault {

		ProductMarketValidation.validateProductMarket(productMarket);

		try {

			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());

			String query = "update product set ProductValue = ?, MarketValue = ? where ID = ?";

			int rowUpdated = jdbcTemplate.update(
					query,
					new Object[] { productMarket.getProductValue(),
							productMarket.getMarketValue(),
							productMarket.getProductId() });

			LOG.debug(" Query for updateProductMarketValue : " + query);

			if (rowUpdated == 1) {
				return "Product value along with market value updated.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("PRODUCT-31571",
					"DB Error: An error occurred while updating product");
		}

		throw new SystemException("PRODUCT-31572",
				"System Error: An error occurred while updating product");

	}

	@Override
	public String deleteProductFromCurrent(ProductIdentity proId)
			throws ProductServiceFault {

		int rowDeleted = 0;

		if (NumericValidation.isAlfaNumeric(proId.getProductId())
				|| Integer.parseInt(proId.getProductId()) < 1) {
			LOG.debug("please provide the valid product id");
			throw new ProductException("PRODUCT-31554",
					"Validation Error: Product Id is not valid.");
		}

		try {

			jdbcTemplate.setDataSource(ProductDataConfig.getDataSource());

			String query = "delete from product where ID = ?";

			rowDeleted = jdbcTemplate.update(query,
					new Object[] { proId.getProductId() });
			LOG.debug(" Query for deleteProductFromCurrent : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("PRODUCT-31573",
					"DB Error: An error occurred while deleting product");
		}

		if (rowDeleted == 1) {
			return "Product Not Exist Any More.";
		}

		throw new SystemException("PRODUCT-31574",
				"System Error: Product already deleted.");

	}

}
