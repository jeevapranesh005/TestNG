package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	WebDriver driver;
	
	//object (action)
	By userName = By.xpath("//input[@placeholder='Username']");
	By password =By.xpath("//input[@placeholder='Password']");
	By titleText = By.xpath("//h5[normalize-space()='Login']");
	By login = By.xpath("//button[normalize-space()='Login']");
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void setUserName(String StrName) {
		driver.findElement(userName).sendKeys(StrName);
	}
	
	public void setPassword(String strpass) {
		driver.findElement(password).sendKeys(strpass);
	}
	
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	//get login
	
	public String getLoginTitle() {
		return driver.findElement(titleText).getText();
	}
	
	public void Login(String strName,String strpass) {
		this.setUserName(strName);
		this.setPassword(strpass);
		this.clickLogin();
	}
}
