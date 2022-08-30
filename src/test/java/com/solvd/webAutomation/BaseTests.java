package com.solvd.webAutomation;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import com.solvd.webAutomation.service.SessionPool;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
public class BaseTests {
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    @BeforeMethod
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterMethod
    public void recordFailure (ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File ("src/test/resources/testFailuresScreeshoots/" + testResult.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @AfterSuite
    public void closeSession(){
        driver.close();
    }
}
