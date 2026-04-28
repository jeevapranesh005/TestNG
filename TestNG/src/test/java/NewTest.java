import org.testng.annotations.Test; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NewTest {
	private static final Logger log = LogManager.getLogger(NewTest.class);
	public WebDriver driver;
	public WebDriverWait mywait ;
	
	
  @Test(priority=1)
  public void correct() {
	  log.info("navigate to login page");
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  log.info("enter username and password");
	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("jeevs");
	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("1234567890");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  
	  WebElement ele =driver.findElement(By.xpath("//a[text()=\"Welcome jeevs\"]"));
	  String act = ele.getText();
	  String exp = "Welcome jeev";
	  
	  Assert.assertEquals(act,exp);
	  System.out.println("login succesfull");
	  log.info("login successful");
	  
  }
  
  @Test(priority=2)
  public void incorrect() {
	  log.info("navigate to login page");
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  log.info("enter username and password as invalid");
	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("jeevs");
	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("123");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  
	  mywait.until(ExpectedConditions.alertIsPresent());
	  Alert alert=driver.switchTo().alert();
	  String act = alert.getText();
	  
	  
	  alert.accept();
	  try {
		 
		  String exp = "Wrong password.";
		  
		  Assert.assertEquals(act,exp);
		  log.info("invalid password");
	  }
	  catch(AssertionError e) {
		  System.out.println("invalid login is accepted");
		  log.error("invalid login is accepted"+e.getMessage());
		  throw e;
	  }
	  
  }
  
  @Test(priority=3)
  public void wrong() {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("john");
	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("1234567890");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  
	  
  }
  
   
 
  
  @BeforeMethod
  public void beforeTest() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--start-maximized");
	  options.addArguments("--headless");
	   driver = new ChromeDriver(options);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.get("https://demoblaze.com/");
	   mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterTest() {
	  driver.quit();
	  
  }

}
