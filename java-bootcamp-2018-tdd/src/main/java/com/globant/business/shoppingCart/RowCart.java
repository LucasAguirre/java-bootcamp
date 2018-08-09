package com.globant.business.shoppingCart;

/**
 * 
 * row of a shopping cart one product and the amount of that product
 *
 */
public class RowCart {
	private Product product;
	private int quantity;

	/**
	 * constructor
	 * 
	 * @param product
	 * @param quantity
	 */
	public RowCart(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}

	public void changeAmmount(int quantity) {
		this.quantity = quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
