package com.globant.business.shoppingCart;

import java.util.Collection;

/**
 * Interface from Shopping Cart service
 */
public interface IShoppingCart {
	/**
	 * add a simple product to the cart
	 * 
	 * @param product
	 */
	public Product addProduct(String name, String category, float price, int quantity);

	/**
	 * change the amount of one product in the cart
	 * 
	 * @param product
	 * @param quantity
	 */
	public Product changeAmount(String product, int quantity);

	/**
	 * remove a existing product of the cart
	 * 
	 * @param product
	 */
	public Product removeProduct(String product);

	/**
	 * 
	 * @return the Subtotal of the purchase
	 */
	public float getSubtotal();

	/**
	 * calculate the total of the purchase and delete all products of the cart
	 * 
	 * @return total price
	 */
	public float process();

	/**
	 * 
	 * @return the amount of products in the list
	 */
	public int amountProducts();

	/**
	 * 
	 * @return the list of rows
	 */
	public Collection<RowCart> getRows();
}
