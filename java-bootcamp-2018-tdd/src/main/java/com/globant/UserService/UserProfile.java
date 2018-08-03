package com.globant.UserService;

/**
 * 
 * basic User Profile getters y setters
 *
 */
public class UserProfile {
	/**
	 * Strings: firstName, lastName,nickName and password self-generated userId
	 */
	private static int idCount = 0;
	private String firstName;
	private String lastName;
	private String nickName;
	private String password;
	private Integer userId;

	public UserProfile(String firstName, String lastName, String nickName, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.password = password;
		this.userId = idCount;
		idCount++;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newPassword) {
		this.password = newPassword;
	}

	public Integer getUserId() {
		return userId;
	}

	/**
	 * equals when their have same userId
	 */
	@Override
	public boolean equals(Object user) {
		if (((UserProfile) user).getUserId() == this.userId) {
			return true;
		}
		return false;
	}
}
