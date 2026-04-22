package test;

import org.testng.annotations.Test;

import utile.ExcelUtility;


import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoNinja 

{
	private static final Logger log = LogManager.getLogger(DemoNinja.class);
	private static final ThreadLocal <WebDriver> driver = new ThreadLocal <WebDriver>();
	
	@Test(dataProvider = "validData", dataProviderClass = ExcelUtility.class)
  public void ValLogin( String email , String pass) 
  {
	  WebDriver driver1 = driver.get();
	  
	  driver1.manage().window().maximize();
	  
	  driver1.get("https://tutorialsninja.com/demo/");
	  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));
	  
	  w 
	  log.info("login with the email :"+email+" and password :"+pass);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"input-email\"]"))).sendKeys(email);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"input-password\"]"))).sendKeys(pass);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"Login\"]"))).click();
	  
	  String actual =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"content\"]/h2[1]"))).getText();
	  
	  String Expect = "My Account";
	  
	  Assert.assertEquals(actual ,Expect);
	  System.out.println("Login successful");
	  log.info("Login successful");
  }
	
	@Test(dataProvider = "invalidData", dataProviderClass = ExcelUtility.class)
	  public void inValLogin( String email , String pass) 
	  {
		  WebDriver driver1 = driver.get();
		  
		  driver1.manage().window().maximize();
		  
		  driver1.get("https://tutorialsninja.com/demo/");
		  
		  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class=\"fa fa-user\"]"))).click();
		  log.info("Navigating to login page");
		   
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Login\"]"))).click();
		  log.info("login with the email :"+email+" and password :"+pass);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"input-email\"]"))).sendKeys(email);
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"input-password\"]"))).sendKeys(pass);
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"Login\"]"))).click();
		  
		  String actual =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]"))).getText();
		  
		  String Expect ="Warning: No match for E-Mail Address and/or Password.";
		  Assert.assertEquals(actual ,Expect);
		  System.out.println("invalid");
		  log.warn("Login failed with invalid credentials");
	  }
	
	@Test(dataProvider = "valSearch", dataProviderClass = ExcelUtility.class)
	  public void valSearch( String str) 
	  {
		  WebDriver driver1 = driver.get();
		  
		  driver1.manage().window().maximize();
		  
		  driver1.get("https://tutorialsninja.com/demo/");
		  
		  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"search\"]"))).sendKeys(str,Keys.ENTER);
		  
		  
		  String actual =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"iMac\"]"))).getText();
//		  
		  String Expect = "iMac";
		  
		  
		  Assert.assertEquals(actual ,Expect);
		  System.out.println("valid Search");
		  
	  }
	
	@Test(dataProvider = "inValSearch", dataProviderClass = ExcelUtility.class)
	  public void inValSearch( String str) 
	  {
		  WebDriver driver1 = driver.get();
		  
		  driver1.manage().window().maximize();
		  
		  driver1.get("https://tutorialsninja.com/demo/");
		  
		  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='search']"))).sendKeys(str,Keys.ENTER);
		  
		  
		  String actual =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'There is no produc')]"))).getText();
//		  
		  String Expect = "There is no product that matches the search criteria.";
		  
		  
		  Assert.assertEquals(actual ,Expect);
		  System.out.println("invalid Search");
		  
	  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("start the test");
	  log.info("Starting the test");
	  driver.set(new ChromeDriver());
  }

  @AfterMethod
  
  public void afterMethod() 
  {
	  WebDriver driver1 = driver.get();
	  
	  if (driver1 != null)
	  {
		  driver1.quit();
	  }
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}