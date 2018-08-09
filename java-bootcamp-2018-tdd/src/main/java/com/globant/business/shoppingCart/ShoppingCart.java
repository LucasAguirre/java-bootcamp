package com.globant.business.shoppingCart;

import java.util.Collection;
import java.util.Hashtable;

public class ShoppingCart implements IShoppingCart {
	/**
	 * Hash whit the rows
	 */
	Hashtable<String, RowCart> products;

	/**
	 * constructor
	 */
	public ShoppingCart() {
		products = new Hashtable<String, RowCart>();
	}

	/**
	 * add a new product to the cart whit its quantity if the product is already in
	 * the cart add the amount
	 */
	public Product addProduct(String name, String category, float price, int quantity) {
		if (!products.containsKey(name)) {
			RowCart row = new RowCart(new Product(name, category, price), quantity);
			products.put(name, row);
		} else {
			products.get(name).addQuantity(quantity);
		}
		return products.get(name).getProduct();
	}

	/**
	 * set the amount of one product in the cart if the new quantity is less than 1,
	 * remove the product
	 */
	public Product changeAmount(String product, int quantity) {
		if (quantity > 0) {
			RowCart current = products.get(product);
			if (current != null) {
				current.changeAmmount(quantity);
				return current.getProduct();
			}
		} else {
			RowCart current = products.get(product);
			if (current != null) {
				removeProduct(product);
				return current.getProduct();
			}
		}
		return null;
	}

	/**
	 * remove a product of the cart
	 */
	public Product removeProduct(String product) {
		if (products.containsKey(product)) {
			RowCart current = products.get(product);
			products.remove(product);
			return current.getProduct();
		}
		return null;
	}

	/**
	 * @return the subtotal of the products in the cart
	 */
	public float getSubtotal() {
		float accum = 0;
		for (RowCart product : products.values()) {
			accum += product.getProduct().getPrice() * product.getQuantity();
		}
		return accum;
	}

	/**
	 * remove all items in the cart and calculate the full price
	 * 
	 * @return the total price of the purchase
	 */
	public float process() {
		float accum = getSubtotal();
		products.clear();
		return accum;
	}

	/**
	 * @return the amount of products
	 */
	public int amountProducts() {
		return products.size();
	}

	/**
	 * 
	 * @return the list of rows
	 */
	public Collection<RowCart> getRows() {
		return this.products.values();
	}

}
