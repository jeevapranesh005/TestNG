package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DemoListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test FAILED: " + result.getName());

        try {
            Object testClass = result.getInstance();
            WebDriver driver = ((demotest) testClass).driver;

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";

            FileUtils.copyFile(source, new File(path));
            System.out.println("Screenshot saved at: " + path);

        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test SKIPPED: " + result.getName());
    }
}