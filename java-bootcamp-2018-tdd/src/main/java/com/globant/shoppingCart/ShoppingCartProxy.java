package com.globant.shoppingCart;

/**
 * 
 * proxy for the Shopping Cart Service
 *
 */
public class ShoppingCartProxy implements IShoppingCart {
	private IShoppingCart shoppingCart;

	public ShoppingCartProxy(IShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public void addProduct(Product product, int quantity) {
		shoppingCart.addProduct(product, quantity);
	}

	public void changeamount(Product product, int quantity) {
		shoppingCart.changeamount(product, quantity);
	}

	public void removeProduct(Product product) {
		shoppingCart.removeProduct(product);
	}

	public double getSubtotal() {
		return shoppingCart.getSubtotal();
	}

	public double process() {
		return shoppingCart.process();
	}

	public int amountProducts() {
		return shoppingCart.amountProducts();
	}

}
