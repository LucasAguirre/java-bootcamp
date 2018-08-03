package com.globant.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.UserService.IUserService;
import com.globant.UserService.UserProfile;
import com.globant.UserService.UserService;
import com.globant.UserService.UserServiceProxy;
/**
 * rest controller for web service
 *
 */
@RestController
public class UserController {

	private final IUserService service = new UserServiceProxy(new UserService());


	// see all users
	@RequestMapping("/users")
	public List<UserProfile> user() {
		return service.findAllUsers();
	}

	// find by id
	@RequestMapping("/user/id")
	public UserProfile userById(@RequestParam(value = "id") int userId) {
		return service.findUserById(userId);
	}

	// find by name
	@RequestMapping("/user/name")
	public List<UserProfile> userbyName(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) {
		return service.findUserByName(firstName, lastName);
	}

	// find by nickname
	@RequestMapping("/user/nickName")
	public UserProfile userByNickName(@RequestParam(value = "nickName") String nickName) {
		return service.findUserByNickName(nickName);
	}

	// create new user
	@RequestMapping("/create")
	public UserProfile create(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "nickName") String nickName,
			@RequestParam(value = "password") String password) {
		return service.addUser(firstName, lastName, nickName, password);
	}

	// delete a a user by id
	@RequestMapping("/delete")
	public UserProfile delete(@RequestParam(value = "id") int userId) {
		UserProfile user = service.findUserById(userId);
		service.deleteUser(userId);
		return user;
	}

	// update last name
	@RequestMapping("/update/lastName")
	public UserProfile updateLastName(@RequestParam(value = "id") int userId,
			@RequestParam(value = "lastName") String lastName) {
		return service.setLastName(userId, lastName);

	}

	// update first name
	@RequestMapping("/update/firstName")
	public UserProfile updateFirstName(@RequestParam(value = "id") int userId,
			@RequestParam(value = "firstName") String firstName) {
		return service.setFirstName(userId, firstName);
	}

	// update nickname
	@RequestMapping("/update/nickName")
	public UserProfile updateNickName(@RequestParam(value = "id") int userId,
			@RequestParam(value = "nickName") String nickName) {
		return service.setNickName(userId, nickName);
	}

	// update password
	@RequestMapping("/update/password")
	public UserProfile updatePassword(@RequestParam(value = "id") int userId,
			@RequestParam(value = "password") String password) {
		return service.setPassword(userId, password);
	}

}
