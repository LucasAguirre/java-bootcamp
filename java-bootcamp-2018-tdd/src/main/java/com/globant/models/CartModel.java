package com.globant.models;

import java.util.List;

/**
 * model of shopping cart
 *
 */
public class CartModel {
	private String userNickName;
	private List<RowCartModel> products;

	/**
	 * @return the products
	 */
	public List<RowCartModel> getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(List<RowCartModel> products) {
		this.products = products;
	}

	/**
	 * @return the userNickName
	 */
	public String getUserNickName() {
		return userNickName;
	}

	/**
	 * @param userNickName
	 *            the userNickName to set
	 */
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

}
