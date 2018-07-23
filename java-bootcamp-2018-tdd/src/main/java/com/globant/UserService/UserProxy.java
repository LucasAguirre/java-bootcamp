package com.globant.UserService;

/**
 * proxy for the updaters method of the userProfile
 *
 */
public class UserProxy {

	private UserProfile user;

	public UserProxy(UserProfile user) {
		this.user = user;
	}

	public UserProxy setFirstName(String firstName) {
		user.setFirstName(firstName);
		return this;
	}

	public UserProxy setLastName(String lastName) {
		user.setLastName(lastName);
		return this;
	}

	public UserProxy setNickName(String nickName) {
		user.setNickName(nickName);
		return this;
	}

	/**
	 * check the current password and set new
	 * 
	 * @param oldPassword
	 * @param newPassword
	 */
	public UserProxy setPassword(String oldPassword, String newPassword) {
		if (oldPassword.equals(user.getPassword())) {
			user.setPassword(newPassword);
		}
		return this;
	}

	public String getFirstName() {
		return user.getFirstName();
	}

	public String getLastName() {
		return user.getLastName();
	}

	public String getNickName() {
		return user.getNickName();
	}

	public String getPassword() {
		return user.getPassword();
	}

	public int getUserId() {
		return user.getUserId();
	}
}
