package DataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
//part2
public class dataprovider1 {
	//public WebDriver driver;
 private static final ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	@Test(dataProvider="testData", dataProviderClass=DataProvider.dataProvider.class)
	
	public void search(String keyword1) throws InterruptedException{
		WebDriver driver1 = driver.get();
		driver1.get("https://www.bing.com/");
		
		WebElement txtbox = driver1.findElement(By.id("sb_form_q"));
		txtbox.sendKeys(keyword1);
		System.out.println("keywords enter is :"+keyword1);
		txtbox.sendKeys(Keys.ENTER);
		
		System.out.println("Search is display");
	}
	
	
	
	
  @BeforeMethod
  public void SetUp() {
		System.out.println("Start");
		driver.set(new ChromeDriver());
	}
  @AfterMethod
public void teardown() {
	WebDriver driver1=driver.get();
	
	if(driver1 !=null) {
		System.out.println("After method thread Id"+Thread.currentThread().getId());
		driver1.quit();
	}
}
  
}



