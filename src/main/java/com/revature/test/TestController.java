package com.revature.test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import org.junit.Before;


import com.revature.controllers.UserController;
import com.revature.model.User;

public class TestController {
	UserController uc = new UserController();
	User legalUser = new User();
	User illegalUser = new User();
	User user;
	User updateUser, deleteUser;
	User newuser, loginuser;
	List<User> loginArray;

	@Before
	public void makeUser() {

		legalUser.setEmail("FromJunitlegal");
		legalUser.setPassword("JunitPasword");
		legalUser.setUsername("Judfiohfother");

		illegalUser.setEmail("Junit.email");
		illegalUser.setPassword("Junit123");
		illegalUser.setUsername("FromJunitIllegal");

		newuser = new User();
		newuser.setEmail("JunitNewUser");
		newuser.setPassword("JunitPasword");
		newuser.setUsername("anothertry");

		updateUser = new User();
		updateUser.setEmail("anotherwtest");
		updateUser.setPassword("JunitUpdatePasword");
		updateUser.setUsername("JunitUpdateUsrName");

	}

	// change username before run
	@Test
	public void testCreateAndDelete() {

		// create user
		      

		assertTrue("Must Return True",  uc.createUser(newuser));

		// delete user test
		//assertTrue(uc.deleteUser(user.getId()));
	}

	@Test
	public void testLogin() {

		System.out.println(legalUser);
		loginArray = uc.login(legalUser);

		assertFalse("Must Return User", loginArray.isEmpty());

		loginArray.clear();

		loginArray = uc.login(illegalUser);

		assertTrue("Must Return empty array", loginArray.isEmpty());

		loginArray.clear();

	}

	@Test
	public void testUpdate() {
		// test update and retrieve

		uc.updateUser(50, updateUser);

		// test updating user user
		updateUser = uc.getUserById(51);
		assertEquals("123", updateUser.getPassword());
	}

}
