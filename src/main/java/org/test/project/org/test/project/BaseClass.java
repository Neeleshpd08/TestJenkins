package org.test.project.org.test.project;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
    public static ExtentReports extent;
    public static ExtentTest test;
    public WebDriver driver;
    
	 public String captureScreenshot(WebDriver driver, String testName) {
	        // Path to save the screenshot
	        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
	            Files.copy(src.toPath(), Paths.get(path));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return path;
	    }

    @BeforeClass
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void startTest(Method method) {
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDownTest(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
        	String screenshotPath = captureScreenshot(driver,result.getName());
            test.fail(result.getThrowable()).addScreenCaptureFromPath(screenshotPath);;
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if(result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped");
        }
        driver.quit();
    }

    @AfterClass
    public void tearDownReport() {
    	extent.flush();
    	driver.quit();
    }
}