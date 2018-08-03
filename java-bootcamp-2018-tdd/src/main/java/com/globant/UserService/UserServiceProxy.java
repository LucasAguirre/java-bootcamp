package com.globant.UserService;

import java.util.List;

/**
 * proxy of the UserService
 *
 */
public class UserServiceProxy implements IUserService {
	IUserService userService;

	public UserServiceProxy(IUserService userService) {
		this.userService = userService;
	}

	public UserProfile addUser(String firstName, String lastName, String nickName, String password) {
		return userService.addUser(firstName, lastName, nickName, password);

	}

	public boolean existUser(String nickName) {
		return userService.existUser(nickName);
	}

	public void deleteUser(UserProfile user) {
		userService.deleteUser(user);

	}

	public void deleteUser(int id) {
		userService.deleteUser(id);

	}

	public UserProfile findUserById(int id) {
		return userService.findUserById(id);
	}

	public UserProfile findUserByNickName(String nickName) {
		return userService.findUserByNickName(nickName);
	}

	public List<UserProfile> findUserByName(String firstName, String lastName) {
		return userService.findUserByName(firstName, lastName);
	}

	public List<UserProfile> findUsersById(int min, int max) {
		return userService.findUsersById(min, max);
	}

	public UserProfile setFirstName(int id, String firstName) {

		return userService.setFirstName(id, firstName);
	}

	public UserProfile setLastName(int id, String lastName) {
		return userService.setLastName(id, lastName);
	}

	public UserProfile setNickName(int id, String nickName) {
		return userService.setNickName(id, nickName);
	}

	public UserProfile setPassword(int id, String password) {
		return userService.setPassword(id, password);
	}

	public List<UserProfile> findAllUsers() {
		return userService.findAllUsers();
	}

}
