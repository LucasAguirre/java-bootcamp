package com.globant.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.globant.business.shoppingCart.IShoppingCart;
import com.globant.business.shoppingCart.RowCart;
import com.globant.business.shoppingCart.ShoppingCart;
import com.globant.models.ProductModel;
import com.globant.models.UserModel;

public class SQLConnection {
	static final String NAME = "name";
	static final String NICKNAME = "nickName";
	static final String LASTNAME = "lastName";
	static final String FIRSTNAME = "firstName";
	static final String PASSWORD = "password";
	static final String ID = "id";
	static final String QUANTITY = "quantity";
	static final String CATEGORY = "category";
	static final String PRICE = "price";
	private Connection connect = null;
	private Statement statement = null;

	/**
	 * Create a connection to the DB
	 * 
	 * @throws Exception
	 */
	public void setUp() {
		try {
			// load the MySQL driver
			Class.forName("com.mysql.jdbc.Driver");
			// connect to DB market
			connect = DriverManager.getConnection("jdbc:mysql://localhost/Market?" + "user=sqluser&password=sqluserpw");
			statement = connect.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * statement and connection
	 */

	public void close() {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}

	/**
	 * search a user by nickname in DB
	 * 
	 * @param nickName
	 * @return a user
	 * @throws SQLException
	 */
	public UserModel findUser(String nickName) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT U.nickName, U.firstName, U.lastName, U.password"
				+ " FROM Users U" + " WHERE U.nickName='" + nickName + "'");
		UserModel user = new UserModel();
		if (resultSet.next()) {
			user.setNickName(resultSet.getString(NICKNAME));
			user.setFirstName(resultSet.getString(FIRSTNAME));
			user.setLastName(resultSet.getString(LASTNAME));
			user.setPassword(resultSet.getString(PASSWORD));
		}
		resultSet.close();
		return user;
	}

	/**
	 * find a saved shopping cart of a user in DB
	 * 
	 * @param nickName
	 * @return a shopping cart
	 * @throws SQLException
	 */
	public IShoppingCart findCart(String nickName) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT R.name, R.quantity"
				+ " FROM Carts C INNER JOIN CartRows R ON C.id=R.id" + " WHERE C.nickName='" + nickName + "'");
		IShoppingCart shoppingCart = new ShoppingCart();
		List<ProductModel> products = new ArrayList<ProductModel>();
		while (resultSet.next()) {
			ProductModel prod = new ProductModel();
			prod.setName(resultSet.getString(NAME));
			prod.setQuantity(resultSet.getInt(QUANTITY));
			products.add(prod);
		}
		resultSet.close();
		for (ProductModel product : products) {
			ProductModel toAdd = findProduct(product.getName());
			shoppingCart.addProduct(product.getName(), toAdd.getCategory(), toAdd.getPrice(), product.getQuantity());
		}
		return shoppingCart;
	}

	/**
	 * search a product for name in the DB
	 * 
	 * @param name
	 * @return a product
	 * @throws SQLException
	 */
	public ProductModel findProduct(String name) throws SQLException {
		ResultSet resultSet = statement.executeQuery(
				"SELECT P.name, P.category, P.price" + " FROM Products P" + " WHERE P.name='" + name + "'");
		ProductModel product = new ProductModel();
		if (resultSet.next()) {
			product.setName(name);
			product.setPrice(resultSet.getFloat(PRICE));
			product.setCategory(resultSet.getString(CATEGORY));
		}
		resultSet.close();
		return product;
	}

	/**
	 * search a cart Id of a user
	 * 
	 * @param nickName
	 * @return a cartId or -1 if the user don´t have a cart created
	 * @throws SQLException
	 */
	public int findCartId(String nickName) throws SQLException {
		ResultSet resultSet = statement
				.executeQuery("SELECT C.id" + " FROM Carts C" + " WHERE C.nickName='" + nickName + "'");
		if (resultSet.next()) {
			return resultSet.getInt(ID);
		}
		resultSet.close();
		return -1;
	}

	/**
	 * add a product in the cart row
	 * 
	 * @param nickName
	 * @param productName
	 * @param quantity
	 * @throws SQLException
	 */
	public void addToCart(String nickName, String productName, int quantity) throws SQLException {
		ProductModel product = findProduct(productName);
		IShoppingCart cart = findCart(nickName);
		cart.addProduct(product.getName(), product.getCategory(), product.getPrice(), quantity);
		saveCart(nickName, cart);
	}

	/**
	 * save a shopping cart in the DB
	 * 
	 * @param nickName
	 * @param cart
	 * @throws SQLException
	 */
	public void saveCart(String nickName, IShoppingCart cart) throws SQLException {
		int id = findCartId(nickName);
		if (id != -1) {
			statement.executeUpdate("DELETE FROM CartRows WHERE id=" + id);
			for (RowCart row : cart.getRows()) {
				statement.executeUpdate("INSERT INTO CartRows (id,name,quantity) VALUES (" + id + " ,'"
						+ row.getProduct().getName() + "'," + row.getQuantity() + ")");
			}
		} else {

			statement.executeUpdate("INSERT INTO Carts (nickName) VALUES ('" + nickName + "')");
			int newId = findCartId(nickName);
			for (RowCart row : cart.getRows()) {
				statement.executeUpdate("INSERT INTO CartRows (id,name,quantity) VALUES (" + newId + " ,'"
						+ row.getProduct().getName() + "'," + row.getQuantity() + ")");
			}
		}
	}

	/**
	 * search all users in the DB
	 * 
	 * @return a list of users
	 * @throws SQLException
	 */
	public List<UserModel> findAllUsers() throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT nickName, firstName, lastName, password" + " FROM Users");
		List<UserModel> users = new ArrayList<UserModel>();
		while (resultSet.next()) {
			UserModel user = new UserModel();
			user.setNickName(resultSet.getString(NICKNAME));
			user.setFirstName(resultSet.getString(FIRSTNAME));
			user.setLastName(resultSet.getString(LASTNAME));
			user.setPassword(resultSet.getString(PASSWORD));
			users.add(user);
		}
		resultSet.close();
		return users;
	}

	/**
	 * search users in the DB for first name and last name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return a list of users
	 * @throws SQLException
	 */
	public List<UserModel> findUserByName(String firstName, String lastName) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT nickName, firstName, lastName, password" + " FROM Users"
				+ " WHERE firstName='" + firstName + "' AND lastName='" + lastName + "'");
		List<UserModel> users = new ArrayList<UserModel>();
		while (resultSet.next()) {
			UserModel user = new UserModel();
			user.setNickName(resultSet.getString(NICKNAME));
			user.setFirstName(resultSet.getString(FIRSTNAME));
			user.setLastName(resultSet.getString(LASTNAME));
			user.setPassword(resultSet.getString(PASSWORD));
			users.add(user);
		}
		resultSet.close();
		return users;
	}

	/**
	 * add a user in the DB
	 * 
	 * @param firstName
	 * @param lastName
	 * @param nickName
	 * @param password
	 * @throws SQLException
	 */
	public void addUser(String firstName, String lastName, String nickName, String password) throws SQLException {
		UserModel user = findUser(nickName);
		if (user.getNickName() == null) {
			statement.executeUpdate("INSERT INTO Users (nickName,firstName,lastName,password) VALUES ('" + nickName
					+ "','" + firstName + "','" + lastName + "','" + password + "')");
		}
	}

	/**
	 * remove a user of the DB
	 * 
	 * @param nickName
	 * @throws SQLException
	 */
	public void deleteUser(String nickName) throws SQLException {
		statement.executeUpdate("DELETE FROM Users WHERE nickName='" + nickName + "'");
	}

	/**
	 * update the fist name field of a user in DB
	 * 
	 * @param nickName
	 * @param firstName
	 * @throws SQLException
	 */
	public void updateFirstName(String nickName, String firstName) throws SQLException {
		statement.executeUpdate(
				"UPDATE Users " + "SET firstName = '" + firstName + "' WHERE nickName='" + nickName + "'");
	}

	/**
	 * update the last name field of a user in DB
	 * 
	 * @param nickName
	 * @param lastName
	 * @throws SQLException
	 */
	public void updateLastName(String nickName, String lastName) throws SQLException {
		statement
				.executeUpdate("UPDATE Users " + "SET lastName = '" + lastName + "' WHERE nickName='" + nickName + "'");
	}

	/**
	 * update the password field of a user in DB
	 * 
	 * @param nickName
	 * @param password
	 * @throws SQLException
	 */
	public void updatePassword(String nickName, String password) throws SQLException {
		statement
				.executeUpdate("UPDATE Users " + "SET password = '" + password + "' WHERE nickName='" + nickName + "'");
	}

	/**
	 * search all products in the DB
	 * 
	 * @return a list of products
	 * @throws SQLException
	 */
	public List<ProductModel> findAllProducts() throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT P.name, P.category, P.price" + " FROM Products P");
		List<ProductModel> products = new ArrayList<ProductModel>();
		while (resultSet.next()) {
			ProductModel product = new ProductModel();
			product.setName(resultSet.getString(NAME));
			product.setPrice(resultSet.getFloat(PRICE));
			product.setCategory(resultSet.getString(CATEGORY));
			products.add(product);
		}
		resultSet.close();
		return products;
	}

	/**
	 * search products for category
	 * 
	 * @param category
	 * @return a list of products
	 * @throws SQLException
	 */
	public List<ProductModel> findProductsByCat(String category) throws SQLException {
		ResultSet resultSet = statement.executeQuery(
				"SELECT P.name, P.category, P.price" + " FROM Products P" + " WHERE P.category='" + category + "'");
		List<ProductModel> products = new ArrayList<ProductModel>();
		while (resultSet.next()) {
			ProductModel product = new ProductModel();
			product.setName(resultSet.getString(NAME));
			product.setPrice(resultSet.getFloat(PRICE));
			product.setCategory(resultSet.getString(CATEGORY));
			products.add(product);
		}
		resultSet.close();
		return products;
	}

	/**
	 * add a product in the DB
	 * 
	 * @param name
	 * @param category
	 * @param price
	 * @throws SQLException
	 */
	public void addProduct(String name, String category, float price) throws SQLException {
		ProductModel product = findProduct(name);
		if (product.getName() == null) {
			statement.executeUpdate("INSERT INTO Products (name,category,price) VALUES ('" + name + "','" + category
					+ "'," + price + ")");
		}
	}

	/**
	 * remove a product in the DB
	 * 
	 * @param name
	 * @throws SQLException
	 */
	public void deleteProduct(String name) throws SQLException {
		statement.executeUpdate("DELETE FROM Products WHERE name='" + name + "'");
	}

	/**
	 * update the category field of a product in the DB
	 * 
	 * @param name
	 * @param category
	 * @throws SQLException
	 */
	public void updateCategory(String name, String category) throws SQLException {
		statement.executeUpdate("UPDATE Products " + "SET category = '" + category + "' WHERE name='" + name + "'");
	}

	/**
	 * 
	 * update the price field of a product in the DB
	 * 
	 * @param name
	 * @param price
	 * @throws SQLException
	 */
	public void updatePrice(String name, float price) throws SQLException {
		statement.executeUpdate("UPDATE Products " + "SET price = '" + price + "' WHERE name='" + name + "'");
	}
}
