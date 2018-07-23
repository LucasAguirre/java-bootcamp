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
	private int userId;

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

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	protected void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	protected void setPassword(String newPassword) {
		this.password = newPassword;
	}

	public int getUserId() {
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
