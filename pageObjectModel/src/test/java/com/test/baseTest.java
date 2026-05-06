package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pages.dashboardPage;
import com.pages.loginPage;

public class baseTest {
	public static WebDriver driver;
	loginPage objLogin;
	dashboardPage objDashboardPage;
	
	@BeforeClass
	public void setup() {
		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*"); 
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterClass
	public void close() {
            driver.quit();   
	}
	
	

}
