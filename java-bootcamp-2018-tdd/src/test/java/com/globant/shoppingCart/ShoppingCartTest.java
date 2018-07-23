package com.globant.shoppingCart;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.globant.UserService.UserProfile;

public class ShoppingCartTest {

	private final IShoppingCart cart = new ShoppingCartProxy(new ShoppingCart());

	private ArrayList<Product> setUp() {
		ArrayList<Product> Products = new ArrayList<Product>();
		Product Product1 = new Product("ProductName1", "ProductDescription", 150);
		Products.add(Product1);
		Product Product2 = new Product("ProductName2", "ProductDescription", 20);
		Products.add(Product2);
		Product Product3 = new Product("ProductName3", "ProductDescription", 10);
		Products.add(Product3);
		Product Product4 = new Product("ProductName4", "ProductDescription", 15);
		Products.add(Product4);
		Product Product5 = new Product("ProductName5", "ProductDescription", 3.5);
		Products.add(Product5);
		Product Product6 = new Product("ProductName6", "ProductDescription", 15.01);
		Products.add(Product6);
		int i = 0;
		for (Product product : Products) {
			i++;
			cart.addProduct(product, i);
		}
		return Products;
	}

	@Test
	public final void testAddProductToCart() {
		setUp();
		assertEquals("the cart do not add products correctly", 6, cart.amountProducts());
		assertEquals("the cart do not add prices correctly", 387.56, cart.getSubtotal(), 0);
	}

	public final void testChageAmount() {
		ArrayList<Product> products = setUp();
		cart.changeamount(products.get(2), 20);
		assertEquals("the cart do not add products correctly", 6, cart.amountProducts());
		assertEquals("the cart do not add prices correctly", 557.56, cart.getSubtotal(), 0);
	}

	@Test
	public final void testDeleteProduct() {
		ArrayList<Product> products = setUp();
		cart.removeProduct(products.get(4));
		assertEquals("the cart do not remove products correctly", 5, cart.amountProducts());
		assertEquals("the cart do not remove products correctly", 370.06, cart.getSubtotal(), 0);
	}

	@Test
	public final void testProcessPruchase() {
		setUp();
		double total = cart.process();
		assertEquals("the car does not process the purchase correctly", 387.56, total, 0);
		assertEquals("the car does not process the purchase correctly", 0, cart.amountProducts());
		assertEquals("the car does not process the purchase correctly", 0, cart.getSubtotal(), 0);

	}

}
