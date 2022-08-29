package com.solvd.webAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.solvd.webAutomation.service.SessionPool;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    @BeforeClass
    public void openDriver(){
        driver = SessionPool.getINSTANCE().getDriver();
    }
    @BeforeMethod
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public void closeSession(){
        driver.close();
    }
}
