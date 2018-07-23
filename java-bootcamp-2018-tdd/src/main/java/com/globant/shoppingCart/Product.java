package com.globant.shoppingCart;

public class Product {
	/**
	 * simple product, Name, Description and price
	 */
	private String name;
	private String desciption;
	private double price;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param description
	 * @param price
	 */
	public Product(String name, String description, double price) {
		this.name = name;
		this.desciption = description;
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
	public String getDesciption() {
		return desciption;
	}

	/**
	 * Set the description of the product
	 * 
	 * @param description
	 */
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	/**
	 * Obtain the price of the product
	 * 
	 * @return (double) the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set the price of the product
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * equals when have the same name, description and price
	 */
	@Override
	public boolean equals(Object product) {
		if ((((Product) product).getName().equalsIgnoreCase(this.name))
				&& (((Product) product).getDesciption().equalsIgnoreCase(this.desciption))
				&& (((Product) product).getPrice() == this.price)) {
			return true;
		}
		return false;

	}
}
