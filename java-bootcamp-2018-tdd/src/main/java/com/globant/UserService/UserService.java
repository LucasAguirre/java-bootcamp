package com.globant.UserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserService implements IUserService {
	/**
	 * list whit all users
	 */
	private ArrayList<UserProfile> users;

	/**
	 * constructor
	 */
	public UserService() {
		users = new ArrayList<UserProfile>();
	}

	/**
	 * add a new user if the nickname is not already register
	 */
	public void addUser(UserProfile user) {
		if (!existUser(user.getNickName())) {
			users.add(user);
		}
	}

	/**
	 * verify if a nickname it's in use
	 */
	public boolean existUser(String nickName) {
		Iterator<UserProfile> it = users.iterator();
		while (it.hasNext()) {
			UserProfile user = it.next();
			if (user.getNickName().equalsIgnoreCase(nickName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * remove a existing user of the system
	 */
	public void deleteUser(UserProfile user) {
		if (users.contains(user)) {
			users.remove(user);
		}

	}

	/**
	 * remove a existing user of the system
	 */
	public void deleteUser(int id) {
		Iterator<UserProfile> it = users.iterator();
		while (it.hasNext()) {
			if (it.next().getUserId() == id) {
				it.remove();
			}
		}
	}

	/**
	 * find a user in the system
	 */
	public UserProfile findUserById(int id) {
		Iterator<UserProfile> it = users.iterator();
		while (it.hasNext()) {
			UserProfile user = it.next();
			if (user.getUserId() == id) {
				return user;
			}
		}
		return null;
	}

	/**
	 * find a user in the system
	 */
	public UserProfile findUserByNickName(String nickName) {
		Iterator<UserProfile> it = users.iterator();
		while (it.hasNext()) {
			UserProfile user = it.next();
			if (user.getNickName().equalsIgnoreCase(nickName)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * find all user in the system with these first and last name
	 */
	public List<UserProfile> findUserByName(String firstName, String lastName) {
		ArrayList<UserProfile> founds = new ArrayList<UserProfile>();
		Iterator<UserProfile> it = users.iterator();
		while (it.hasNext()) {
			UserProfile user = it.next();
			if ((user.getFirstName().equalsIgnoreCase(firstName)) && (user.getLastName().equalsIgnoreCase(lastName))) {
				founds.add(user);
			}
		}
		if (founds.size() > 0) {
			return founds;
		}
		return null;
	}

	/**
	 * find all user in the system with userId between two values
	 */
	public List<UserProfile> findUsersById(int min, int max) {
		ArrayList<UserProfile> toReturn = new ArrayList<UserProfile>();
		Iterator<UserProfile> it = users.iterator();
		while (it.hasNext()) {
			UserProfile user = it.next();
			if ((user.getUserId() >= min) && (user.getUserId() <= max)) {
				toReturn.add(user);
			}
		}
		if (toReturn.size() > 0) {
			return toReturn;
		}
		return null;
	}

	/**
	 * @return a UserProxy for call updaters methods
	 */
	public UserProxy updateUser(UserProfile user) {
		if (user != null) {
			return new UserProxy(user);
		}
		return null;
	}

}
