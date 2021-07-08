package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginPageTestCase {

	private static SeleniumExample seleniumExample;
	private String expectedTitle = "";
	
	@BeforeEach
	public void setUp() {
		seleniumExample = new SeleniumExample();
	}

	@AfterEach
	public void tearDown() throws InterruptedException {
		seleniumExample.closeWindow();
	}
	
	@Test
	public void testLoginPage() throws InterruptedException {
		seleniumExample.getLogin();
		String expectedTitle = "Login";
		String actualTitle = seleniumExample.getTitle();
		Thread.sleep(5000);
		assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void testLogin() throws InterruptedException {
		seleniumExample.getLogin();
		String testUsername = "jtsb";
		String testPassword = "jtsb";
		seleniumExample.sendCredentials(testUsername, testPassword);
		expectedTitle = "Successful!";
		String actualTitle = seleniumExample.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void testLoginFail() throws InterruptedException {
		seleniumExample.getLogin();
		String testUsername = "";
		String testPassword = "jtsb";
		seleniumExample.sendCredentials(testUsername, testPassword);
		expectedTitle = "UnSuccessful!";
		String actualTitle = seleniumExample.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
}
