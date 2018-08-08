package com.globant.business.shoppingCart;

public class Product {
	/**
	 * simple product, Name, Description and price
	 */
	private String name;
	private String category;
	private float price;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param description
	 * @param price
	 */
	public Product(String name, String category, float price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	/**
	 * Obtain the name of the product
	 * 
	 * @return (String) the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the product
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtain the description of the product
	 * 
	 * @return (String) the description
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Set the description of the product
	 * 
	 * @param description
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Obtain the price of the product
	 * 
	 * @return (float) the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Set the price of the product
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * equals when have the same name, description and price
	 */
	@Override
	public boolean equals(Object product) {
		Product prod = (Product) product;
		if ((prod.getName().equalsIgnoreCase(this.name)) && (prod.getCategory().equalsIgnoreCase(this.category))
				&& (prod.getPrice() == this.price)) {
			return true;
		}
		return false;

	}
}
