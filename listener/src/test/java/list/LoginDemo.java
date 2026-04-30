package list;

import org.testng.annotations.*;

import list.ListenerDemo;

import java.time.Duration;

import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import org.testng.Assert;
@Listeners(ListenerDemo.class)
public class LoginDemo {
    public static ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();
    public static Logger log = LogManager.getLogger(LoginDemo.class);

    @BeforeMethod
    public void setup() {
        log.info("Browser Initializing");
        driver1.set(new ChromeDriver());
    }

    @Test(dataProvider = "validData", dataProviderClass = utile.ExcelUtility.class, priority = 1)
    public void validLogin(String email, String password) {

        WebDriver driver = driver1.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a[href*='login']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated( By.cssSelector("h2:nth-child(1)"))).getText();
        String expected = "My Account";
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "invalidData", dataProviderClass = utile.ExcelUtility.class, priority = 2)
    public void invalidLogin(String email,String password){
        WebDriver driver = driver1.get();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a[href*='login']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-danger"))).getText();
        Assert.assertTrue(actual.contains("kwkk"));
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = driver1.get();
        if (driver != null) {
            driver.quit();
            driver1.remove();
        }
    }
}