package com.globant.controller;

import java.util.Hashtable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.business.shoppingCart.IShoppingCart;
import com.globant.dbConnection.SQLConnection;
import com.globant.dbConnection.SQLSingleton;
import com.globant.models.ProductModel;
import com.globant.models.RowCartModel;
import com.globant.models.UserModel;

/**
 * main rest controller for web service
 *
 */
@RestController
public class MainController {
	private final static Hashtable<String, String> sessions = new Hashtable<String, String>();
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static SQLConnection sql;

	protected static void setUP() throws Exception {
		sql = SQLSingleton.getInstance();
	}

	/**
	 * login user and generate a session
	 * 
	 * @param user
	 * @return the session id
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody UserModel user) throws Exception {
		UserModel userProfile = sql.findUser(user.getNickName());
		if (userProfile != null) {
			if (userProfile.getPassword().equals(user.getPassword())) {
				return getSessionId(user.getNickName());
			}
		}
		return null;
	}

	/**
	 * add product to the cart of a user if the product already in the cart, add the
	 * quantities
	 * 
	 * @param session
	 * @param product
	 * @return the product added
	 * @throws Exception
	 */
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public RowCartModel addProduct(@RequestHeader(value = "sessionId") String session,
			@RequestBody RowCartModel product) throws Exception {
		UserModel currentUserModel = sql.findUser(sessions.get(session));
		if (currentUserModel != null) {
			sql.addToCart(currentUserModel.getNickName(), product.getProductName(), product.getQuantity());
			return product;
		}
		return null;
	}

	/**
	 * change the amount of a product in the cart
	 * 
	 * @param session
	 * @param product
	 * @return the product
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeAmmount", method = RequestMethod.PUT)
	public RowCartModel changeAmmount(@RequestHeader(value = "sessionId") String session,
			@RequestBody RowCartModel product) throws Exception {
		UserModel currentUserModel = sql.findUser(sessions.get(session));
		if (currentUserModel != null) {
			IShoppingCart cart = sql.findCart(currentUserModel.getNickName());
			cart.changeamount(product.getProductName(), product.getQuantity());
			sql.saveCart(currentUserModel.getNickName(), cart);
			return product;
		}
		return null;
	}

	/**
	 * remove a product of the cart
	 * 
	 * @param session
	 * @param product
	 * @throws Exception
	 */
	@RequestMapping(value = "/removeProduct", method = RequestMethod.DELETE)
	public void removeProduct(@RequestHeader(value = "sessionId") String session, @RequestBody ProductModel product)
			throws Exception {
		UserModel currentUserModel = sql.findUser(sessions.get(session));
		if (currentUserModel != null) {
			IShoppingCart cart = sql.findCart(currentUserModel.getNickName());
			cart.removeProduct(product.getName());
			sql.saveCart(currentUserModel.getNickName(), cart);
		}
	}

	/**
	 * get a sub total of purchase
	 * 
	 * @param session
	 * @return the sub total
	 */
	@RequestMapping(value = "/getSubTotal", method = RequestMethod.GET)
	public float getSubTotal(@RequestHeader(value = "sessionId") String session) throws Exception {
		UserModel currentUserModel = sql.findUser(sessions.get(session));
		if (currentUserModel != null) {
			return sql.findCart(currentUserModel.getNickName()).getSubtotal();
		}
		return (float) 0;
	}

	/**
	 * proceed with the purchase (empty the cart and return the total cost of
	 * products)
	 * 
	 * @param session
	 * @return the total cost
	 */
	@RequestMapping(value = "/proceed", method = RequestMethod.GET)
	public float proceed(@RequestHeader(value = "sessionId") String session) throws Exception {
		UserModel currentUserModel = sql.findUser(sessions.get(session));
		IShoppingCart cart = sql.findCart(currentUserModel.getNickName());
		float total = cart.process();
		sql.saveCart(currentUserModel.getNickName(), cart);
		return total;
	}

	/**
	 * get the amount of products in the cart (only the quantity of different
	 * products, not the sum of their quantities)
	 * 
	 * @param session
	 * @return the amount of different products
	 */
	@RequestMapping(value = "/amountOfProducts", method = RequestMethod.GET)
	public Integer amountOfProducts(@RequestHeader(value = "sessionId") String session) throws Exception {
		UserModel currentUserModel = sql.findUser(sessions.get(session));
		return sql.findCart(currentUserModel.getNickName()).amountProducts();
	}

	/**
	 * log out the user, remove the session
	 * 
	 * @param session
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.PUT)
	public void logout(@RequestHeader(value = "sessionId") String session) {
		sessions.remove(session);
	}

	/**
	 * get a random Session Id
	 * 
	 * @param currentUserModel
	 * @return the session id
	 */
	private String getSessionId(String currentUserModel) {
		String session = randomAlphaNumeric(10);
		while (sessions.containsKey(session)) {
			session = randomAlphaNumeric(10);
		}
		sessions.put(session, currentUserModel);
		return session;
	}

	/**
	 * generate a random alpha numeric String
	 * 
	 * @param count
	 * @return the String generated
	 */
	private static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
