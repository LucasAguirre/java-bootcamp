package com.globant.UserService;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserServiceTest {

	private final IUserService userService = new UserServiceProxy(new UserService());

	private ArrayList<UserProfile> setUp() {
		ArrayList<UserProfile> users = new ArrayList<UserProfile>();
		UserProfile user1 = new UserProfile("firstName1", "lastName", "User1", "password");
		users.add(user1);
		UserProfile user2 = new UserProfile("firstName2", "lastName", "User2", "password");
		users.add(user2);
		UserProfile user3 = new UserProfile("firstName3", "lastName", "User3", "password");
		users.add(user3);
		UserProfile user4 = new UserProfile("firstName4", "lastName", "User4", "password");
		users.add(user4);
		UserProfile user5 = new UserProfile("firstName5", "lastName", "User5", "password");
		users.add(user5);
		UserProfile user6 = new UserProfile("firstName6", "lastName", "User6", "password");
		users.add(user6);
		for (UserProfile user : users) {
			userService.addUser(user);
		}
		return users;
	}

	@Test
	public final void testAddNewUser() {
		ArrayList<UserProfile> users = setUp();
		assertEquals("The user service not create correctly a user", users.get(0),
				userService.findUserById(users.get(0).getUserId()));
		assertEquals("The user service not create correctly a user", users.get(1),
				userService.findUserById(users.get(1).getUserId()));
		assertEquals("The user service not create correctly a user", users.get(2),
				userService.findUserById(users.get(2).getUserId()));
	}

	@Test
	public final void testDeleteUser() {
		ArrayList<UserProfile> users = setUp();
		userService.deleteUser(users.get(3).getUserId());
		assertEquals("the functionality of delete a user doesn't work", true,
				userService.existUser(users.get(0).getNickName()));
		assertEquals("the functionality of delete a user doesn't work", true,
				userService.existUser(users.get(1).getNickName()));
		assertEquals("the functionality of delete a user doesn't work", true,
				userService.existUser(users.get(2).getNickName()));
		assertEquals("the functionality of delete a user doesn't work", false,
				userService.existUser(users.get(3).getNickName()));
		assertEquals("the functionality of delete a user doesn't work", true,
				userService.existUser(users.get(4).getNickName()));
		assertEquals("the functionality of delete a user doesn't work", true,
				userService.existUser(users.get(5).getNickName()));
	}

	@Test
	public final void testUpdateUser() {
		ArrayList<UserProfile> users = setUp();
		userService.updateUser(users.get(3)).setFirstName("UpdatedFirsName").setLastName("UpdatedLastName");
		assertEquals("The Service not Update a user correctly", "UpdatedFirsName",
				userService.findUserById(users.get(3).getUserId()).getFirstName());
		assertEquals("The Service not Update a user correctly", users.get(3),
				userService.findUserByName("UpdatedFirsName", "UpdatedLastName").get(0));
	}

	@Test
	public final void testFindUser() {
		ArrayList<UserProfile> users = setUp();
		UserProfile userById = userService.findUserById(users.get(2).getUserId());
		assertEquals("The service doesn't find good by user id", users.get(2), userById);

		List<UserProfile> usersByName = userService.findUserByName(users.get(4).getFirstName(),
				users.get(4).getLastName());
		assertEquals("The service doesn't find good by user name", 1, usersByName.size());
		assertEquals("The service doesn't find good by user name", users.get(4), usersByName.get(0));

		UserProfile userByNickName = userService.findUserByNickName(users.get(0).getNickName());
		assertEquals("The service doesn't find good by user nickname ", users.get(0), userByNickName);
	}
}
