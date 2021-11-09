package com.service;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.FurnitureUser;
import com.exception.UserNotFoundException;
import com.services.UserManagementService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserManagementTest {
	@Autowired
	UserManagementService service;
	
	final Logger LOGGER =	LoggerFactory.getLogger(this.getClass());
	private static int uId;
	
	
	@Test
	@Order(1)
	void testregisterNewUser() {
		
		LOGGER.info("TEST CASE TC_01");
		FurnitureUser user=new FurnitureUser(1, "password", "admin", "username");
		try
		{
			FurnitureUser dto = service.registerNewUser(user);
		user.setUId(dto.getUId());
		boolean equals=false;
		equals = dto.getPassword().equals(user.getPassword()) && dto.getRole().equals(user.getRole()) && dto.getUsername().equals(dto.getUsername());
		uId=dto.getUId();
		assertTrue(equals);
		if(equals)
			LOGGER.info("User added successfully");
		else
			LOGGER.error("User is not added");
		}
		catch(UserNotFoundException e)
		{
			LOGGER.error("User is not added due to " + e.getMessage());
			fail("User is not added");
		}
	}

	@Test
	@Order(2)
	void testAddUserAgain() {
		
		LOGGER.info("TEST CASE TC_02");
		FurnitureUser user=new FurnitureUser(1, "password", "admin", "username");
		assertThrows(UserNotFoundException.class,()->service.registerNewUser(user));
		LOGGER.info("Multiple users with same user name not allowed");
	}
	
	/*
	 * Test method for {@link com.cg.cars.service.UserServiceImpl #updateUser()}.
	 */
	@Order(3)
	@Test
	void testUpdateUser() throws UserNotFoundException {
		LOGGER.info("TEST CASE TC_05");
		FurnitureUser user=new FurnitureUser(uId, "pwdnew", "admin", "username");
		FurnitureUser dto = service.updateUser(user);
		assertNotNull(dto);
		LOGGER.info("User with valid ID got updated");
	}

	@Order(4)
	@Test
	void testUpdateUserInvalidID() {
		LOGGER.info("TEST CASE TC_06");
		FurnitureUser user=new FurnitureUser(150, "pwdnew", "admin", "username");
		assertThrows(UserNotFoundException.class, ()-> service.updateUser(user));
		LOGGER.info("User with invalid ID thrown UserServiceException");
	}
	

	

	/*
	 * Test method for {@link com.cg.cars.service.UserServiceImpl #DeleteUser()}.
	 */
	@Order(5)
	@Test
	void testDeleteUserById() {
		LOGGER.info("TEST CASE TC_15");
		try {
			assertNotNull(service.deleteUserById(uId));
			LOGGER.info("User is deleted with valid ID");
		} catch (UserNotFoundException e) {
			fail("User cannot be deleted due to " + e.getMessage());
		}
	}
	
	@Order(6)
	@Test
	void testDeleteUser() {
		LOGGER.info("TEST CASE TC_15");
		try {
			assertNotNull(service.deleteUser());
			LOGGER.info("User is deleted with valid ID");
		} catch (UserNotFoundException e) {
			fail("User cannot be deleted due to " + e.getMessage());
		}
	}

	@Order(7)
	@Test
	void testDeleteUserInvalidID() {
		LOGGER.info("TEST CASE TC_16");
		assertThrows(UserNotFoundException.class, ()->service.deleteUserById(1000));
		LOGGER.info("User with invalid ID thrown exception");
	}
	
	

	
}
