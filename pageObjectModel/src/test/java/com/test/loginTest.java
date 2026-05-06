package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.loginPage;

public class loginTest extends baseTest{
	
	@Test
	public void loginTest() {
		objLogin = new loginPage(driver);
		
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
	}

}
