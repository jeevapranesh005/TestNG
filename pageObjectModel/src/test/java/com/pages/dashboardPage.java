package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboardPage {
	WebDriver driver;
	
	By dashboadpage = By.xpath("//h6[normalize-space()='Dashboard']");
	
	public dashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getHomePageText() {
		return driver.findElement(dashboadpage).getText();
	}
}
