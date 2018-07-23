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

	public void addUser(UserProfile user) {
		userService.addUser(user);

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

	public UserProxy updateUser(UserProfile user) {
		return userService.updateUser(user);
	}

}
