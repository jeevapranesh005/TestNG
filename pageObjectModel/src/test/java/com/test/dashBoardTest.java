package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.dashboardPage;
import com.pages.loginPage;

public class dashBoardTest extends baseTest {

	@Test
	public void dashboardTest() {
		objLogin = new loginPage(driver);
		
		objLogin.Login("Admin", "admin123");
		objDashboardPage = new dashboardPage(driver);
		String dash = objDashboardPage.getHomePageText();
		Assert.assertTrue(dash.contains("Dashboard"));
	}
	
	
}
