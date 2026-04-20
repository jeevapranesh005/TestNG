package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//sequencial method1
public class DataProviderDemo1 {
WebDriver driver;
@DataProvider(name="testData" ,parallel=true)
public  Object[][] dataProviderfun(){
	return new Object[][] {{"Selenium"},{"TestNG"}};
}

@BeforeMethod
public void SetUp() {
	System.out.println("Start");
	driver = new ChromeDriver();
	driver.get("https://www.bing.com/");
	driver.manage().window().maximize();
}


@Test(dataProvider="testData")
public void search(String keyword) {
	WebElement texbox = driver.findElement(By.id("sb_form_q"));
	texbox.sendKeys(keyword);
	System.out.println("keyword enter as: "+keyword);
	texbox.sendKeys(Keys.ENTER);
	System.out.println("Search result is display");
}

@AfterMethod
public void teardown() {
	driver.quit();
	System.out.println("End the test");
}





}
