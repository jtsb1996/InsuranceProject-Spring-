package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class RegisterPageTestCase {

	@Autowired
	private static SeleniumExample seleniumExample;
	private String expectedTitle = "";
	
	@BeforeEach
	public void setUp() {
		System.out.println("Setup test case");
		seleniumExample = new SeleniumExample();
	}

	@AfterEach
	public void tearDown() throws InterruptedException {
		seleniumExample.closeWindow();
	}

	@Test
	public void testRegisterPage() {
		seleniumExample.getRegistration();
		String expectedTitle = "Registration Page";
		String actualTitle = seleniumExample.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void testRegister() throws InterruptedException {
		seleniumExample.getRegistration();
		String testName = "qwe";
		String testAge = "9";
		String testUserName = "qwer123";
		String testPassword = "qwer123";
		String testAnswer = "123";
		seleniumExample.sendCredentials(testName, testAge, testUserName, testPassword, testAnswer);
		expectedTitle = "Welcome to Insure Insurance Website";
		String actualTitle = seleniumExample.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void testRegisterFail() throws InterruptedException {
		seleniumExample.getRegistration();
		String testName = "";
		String testAge = "9";
		String testUserName = "qwer123";
		String testPassword = "qwer123";
		String testAnswer = "123";
		seleniumExample.sendCredentials(testName, testAge, testUserName, testPassword, testAnswer);
		expectedTitle = "Registration Page";
		String actualTitle = seleniumExample.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}

}
