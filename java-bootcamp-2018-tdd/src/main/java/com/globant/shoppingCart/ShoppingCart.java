package com.globant.shoppingCart;

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
	public void addProduct(Product product, int quantity) {
		if (product != null) {
			if (!products.containsKey(product.getName())) {
				RowCart row = new RowCart(product, quantity);
				products.put(product.getName(), row);
			} else {
				products.get(product.getName()).addQuantity(quantity);
			}
		}
	}

	/**
	 * set the amount of one product in the cart if the new quantity is less than 1,
	 * remove the product
	 */
	public void changeamount(Product product, int quantity) {
		if (quantity > 0) {
			products.get(product.getName()).setQuantity(quantity);
		} else {
			removeProduct(product);
		}
	}

	/**
	 * remove a product of the cart
	 */
	public void removeProduct(Product product) {
		if (products.containsKey(product.getName())) {
			products.remove(product.getName());
		}

	}

	/**
	 * @return the subtotal of the products in the cart
	 */
	public double getSubtotal() {
		double accum = 0;
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
	public double process() {
		double accum = getSubtotal();
		products.clear();
		return accum;
	}

	/**
	 * @return the amount of products
	 */
	public int amountProducts() {
		return products.size();
	}

}
