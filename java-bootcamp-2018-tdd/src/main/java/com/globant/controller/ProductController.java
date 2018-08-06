package com.globant.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.dbConnection.SQLConnection;
import com.globant.dbConnection.SQLSingleton;
import com.globant.models.ProductModel;

/**
 * rest controller for the user control
 *
 */
@RestController
public class ProductController {
	private static SQLConnection sql;

	protected static void setUP() throws Exception {
		sql = SQLSingleton.getInstance();
	}

	/**
	 * list all products in the DB
	 * 
	 * @return List of products
	 * @throws SQLException
	 */
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public List<ProductModel> product() throws SQLException {
		return sql.findAllProducts();
	}

	/**
	 * search a product by name
	 * 
	 * @param name
	 * @return a product with same name
	 * @throws SQLException
	 */
	@RequestMapping(value = "/product/name", method = RequestMethod.GET)
	public ProductModel findByName(String name) throws SQLException {
		return sql.findProduct(name);
	}

	/**
	 * search products by category
	 * 
	 * @param category
	 * @return List of products
	 * @throws SQLException
	 */
	@RequestMapping(value = "/product/category", method = RequestMethod.GET)
	public List<ProductModel> findProductsByCat(String category) throws SQLException {
		return sql.findProductsByCat(category);
	}

	/**
	 * create a new product
	 * 
	 * @param product
	 * @throws SQLException
	 */
	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	public void create(@RequestBody ProductModel product) throws SQLException {
		sql.addProduct(product.getName(), product.getCategory(), product.getPrice());
	}

	/**
	 * remove a product of the DB
	 * 
	 * @param product
	 * @throws SQLException
	 */
	@RequestMapping(value = "/product/delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody ProductModel product) throws SQLException {
		ProductModel prod = sql.findProduct(product.getName());
		if (prod != null) {
			sql.deleteProduct(prod.getName());
		}
	}

	/**
	 * update the category field of a product
	 * 
	 * @param product
	 * @throws SQLException
	 */
	@RequestMapping(value = "/product/update/category", method = RequestMethod.PUT)
	public void updateCategory(@RequestBody ProductModel product) throws SQLException {
		ProductModel prod = sql.findProduct(product.getName());
		if (prod != null) {
			sql.updateCategory(product.getName(), product.getCategory());
		}
	}

	/**
	 * update the price field of a product
	 * 
	 * @param product
	 * @throws SQLException
	 */
	@RequestMapping(value = "/product/update/price", method = RequestMethod.PUT)
	public void updatePrice(@RequestBody ProductModel product) throws SQLException {
		ProductModel prod = sql.findProduct(product.getName());
		if (prod != null) {
			sql.updatePrice(product.getName(), product.getPrice());
		}
	}
}
