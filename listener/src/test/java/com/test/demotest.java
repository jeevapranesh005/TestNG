package com.test;

import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

@Listeners(demolistenerfail.class)
public class demotest {

    public WebDriver driver;
    private static final Logger log = LogManager.getLogger(demotest.class);

    @BeforeMethod
    public void beforeTest() {
        log.info("Launching browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @Test
    public void loginTest() {
        log.info("Clicking My Account");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();

        log.info("Clicking Login");
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();

        log.info("Entering credentials");
        driver.findElement(By.id("input-email")).sendKeys("2k22it17@kiot.ac.in");
        driver.findElement(By.id("input-password")).sendKeys("Jeeva@11");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String title = driver.getTitle();
        log.info("Page title is: " + title);

        Assert.assertTrue(title.contains("Account"));
    }

    @AfterMethod
    public void afterTest() {
        log.info("Closing browser");
        if (driver != null) {
            driver.quit();
        }
    }
}