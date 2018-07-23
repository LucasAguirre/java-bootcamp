package com.globant.UserService;

import java.util.List;

public interface IUserService {
	/**
	 * add a new user to the system
	 * 
	 * @param user
	 */
	public void addUser(UserProfile user);

	/**
	 * verify if a nickname is already registered
	 * 
	 * @param nickName
	 * @return true if the is already registered
	 */
	public boolean existUser(String nickName);

	/**
	 * remove a user of the system
	 * 
	 * @param user
	 */
	public void deleteUser(UserProfile user);

	/**
	 * remove a user of the system
	 * 
	 * @param id
	 */
	public void deleteUser(int id);

	/**
	 * find a user in the system
	 * 
	 * @param id
	 * @return the user or null if doesn't exist
	 */
	public UserProfile findUserById(int id);

	/**
	 * find a user in the system
	 * 
	 * @param nickName
	 * @return the user or null if doesn't exist
	 */
	public UserProfile findUserByNickName(String nickName);

	/**
	 * find all user in the system with these first and last name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return a list of users or null if doesn't exist
	 */
	public List<UserProfile> findUserByName(String firstName, String lastName);

	/**
	 * find all user in the system with userId between two values
	 * 
	 * @param min
	 * @param max
	 * @return a list of users or null if doesn't exist
	 */
	public List<UserProfile> findUsersById(int min, int max);

	/**
	 * return a proxy for user's updates
	 * 
	 * @param user
	 * @return a UserProxy for call updaters methods
	 */
	public UserProxy updateUser(UserProfile user);

}
