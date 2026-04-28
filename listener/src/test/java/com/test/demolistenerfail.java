package com.test;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class demolistenerfail implements ITestListener {

    private static final Logger log = LogManager.getLogger(demolistenerfail.class);

    public void onTestStart(ITestResult result) {
        log.info(result.getName() + " test started");
    }

    public void onTestSuccess(ITestResult result) {
        log.info("Test PASSED: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        log.error("Test FAILED: " + result.getName());

        Object testClass = result.getInstance();
        WebDriver driver = ((demotest) testClass).driver;

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";

        try {
            FileUtils.copyFile(source, new File(path));
            log.info("Screenshot saved at: " + path);
        } catch (IOException e) {
            log.error("Screenshot failed: " + e.getMessage());
        }
    }

    public void onTestSkipped(ITestResult result) {
        log.warn("Test SKIPPED: " + result.getName());
    }
}