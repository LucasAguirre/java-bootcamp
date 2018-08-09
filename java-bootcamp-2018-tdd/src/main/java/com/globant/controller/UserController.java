package com.globant.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.dbConnection.SQLConnection;
import com.globant.dbConnection.SQLSingleton;
import com.globant.models.UserModel;

/**
 * rest controller for the user control
 *
 */
@RestController
public class UserController {
	private static SQLConnection sql;

	protected static void setUP() throws Exception {
		sql = SQLSingleton.getInstance();
	}

	/**
	 * search all users in DB
	 * 
	 * @return list of users
	 * @throws SQLException
	 */
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public List<UserModel> users() throws SQLException {
		return sql.findAllUsers();
	}

	/**
	 * search users by first name and last name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return list of users
	 * @throws SQLException
	 */
	@RequestMapping(value = "/user/name", method = RequestMethod.GET)
	public List<UserModel> userbyName(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) throws SQLException {
		return sql.findUserByName(firstName, lastName);
	}

	/**
	 * search a user by nickname
	 * 
	 * @param nickName
	 * @return a user
	 * @throws SQLException
	 */
	@RequestMapping(value = "/user/nickName", method = RequestMethod.GET)
	public UserModel userByNickName(@RequestParam(value = "nickName") String nickName) throws SQLException {
		return sql.findUser(nickName);
	}

	/**
	 * create a new user in DB
	 * 
	 * @param user
	 * @throws SQLException
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public void create(@RequestBody UserModel user) throws SQLException {
		sql.addUser(user.getFirstName(), user.getLastName(), user.getNickName(), user.getPassword());
	}

	/**
	 * remove a user in the DB
	 * 
	 * @param user
	 * @return the user removed
	 * @throws SQLException
	 */
	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
	public UserModel delete(@RequestBody UserModel user) throws SQLException {
		UserModel userfetch = sql.findUser(user.getNickName());
		if (user.getPassword().equals(userfetch.getPassword())) {
			sql.deleteUser(user.getNickName());
		}
		return user;
	}

	/**
	 * update the fist name field of a user
	 * 
	 * @param user
	 * @throws SQLException
	 */
	@RequestMapping(value = "/user/update/firstName", method = RequestMethod.PUT)
	public void updateFirstName(@RequestBody UserModel user) throws SQLException {
		UserModel userfetch = sql.findUser(user.getNickName());
		if (user.getPassword().equals(userfetch.getPassword())) {
			sql.updateFirstName(user.getNickName(), user.getFirstName());
		}
	}

	/**
	 * update the last name field of a user
	 * 
	 * @param user
	 * @throws SQLException
	 */
	@RequestMapping(value = "/user/update/lastName", method = RequestMethod.PUT)
	public void updateLastName(@RequestBody UserModel user) throws SQLException {
		UserModel userfetch = sql.findUser(user.getNickName());
		if (user.getPassword().equals(userfetch.getPassword())) {
			sql.updateLastName(user.getNickName(), user.getLastName());
		}

	}

	/**
	 * update the password field of a user
	 * 
	 * @param user
	 * @throws SQLException
	 */
	@RequestMapping(value = "/user/update/password", method = RequestMethod.PUT)
	public void updatePassword(@RequestBody UserModel user) throws SQLException {
		UserModel userfetch = sql.findUser(user.getNickName());
		if (user.getPassword().equals(userfetch.getPassword())) {
			sql.updatePassword(user.getNickName(), user.getFirstName());
		}
	}

}
