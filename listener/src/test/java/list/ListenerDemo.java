//Listener
package list;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        try {
            captureScreenshot(result);
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
    public void captureScreenshot(ITestResult result) throws IOException {
        Object currentClass = result.getInstance();
        WebDriver driver = ((LoginDemo) currentClass).driver1.get();
        if (driver == null) {
            System.out.println("Driver is NULL → Screenshot skipped");
            return;
        }
        if (!(driver instanceof TakesScreenshot)) {
            System.out.println("Driver does not support screenshot");
            return;
        }
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + result.getName() + ".png");
        dest.getParentFile().mkdirs();
        FileUtils.copyFile(src, dest);
        System.out.println("Screenshot captured: " + dest.getAbsolutePath());
    }
}