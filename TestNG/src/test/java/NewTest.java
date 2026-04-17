import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	public WebDriver driver;
  @Test(priority=3)
  public void correct() {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("jeevs");
	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("1234567890");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  
  }
  
  @Test(priority=1)
  public void incorrect() {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("jeevs");
	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("123");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  
  }
  
  @Test(priority=2,dependsOnMethods="correct")
  public void wrong() {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("john");
	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("1234567890");
	  driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	  
  }
 
  
  @BeforeMethod
  public void beforeTest() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--start maximized");
	  options.addArguments("--headless");
	   driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.get("https://demoblaze.com/");
  }

  @AfterMethod
  public void afterTest() {
	  driver.quit();
	  
  }

}
