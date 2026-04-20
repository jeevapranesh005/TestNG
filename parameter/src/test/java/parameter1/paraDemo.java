package parameter1;

import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class paraDemo {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public WebDriverWait mywait ;
    public WebDriver getDriver() {
        return driver.get();
    }

   
    @BeforeMethod
    @Parameters({"browser","url"})
    public void setup(String browser, String url) {

        if(browser.equalsIgnoreCase("firefox")){
            driver.set(new FirefoxDriver());
        }
        else {
            driver.set(new ChromeDriver());
        }
        
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        getDriver().manage().window().maximize();
        mywait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        getDriver().get(url);
    }

  
    @Test
    @Parameters({"Vuser","Vpass"})
    public void validLogin(String user, String pass) {

        WebDriver driver = getDriver();

        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(user);
        driver.findElement(By.id("loginpassword")).sendKeys(pass);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement ele =driver.findElement(By.xpath("//a[text()=\"Welcome jeevs\"]"));
  	  	String act = ele.getText();
  	  	String exp = "Welcome jeevs";
  	  
  	  	Assert.assertEquals(act,exp);
  	  	System.out.println("login succesfull");
       
    }

    
    @Test(dataProvider="testData", dataProviderClass=dataprovider.class)
    public void invalidLogin(String user, String pass) {

        WebDriver driver = getDriver();

        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(user);
        driver.findElement(By.id("loginpassword")).sendKeys(pass);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        System.out.println("Login attempt with user: " + user + " and pass: " + pass);
    }

    // 🔹 Tear Down
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove(); 
    }
}