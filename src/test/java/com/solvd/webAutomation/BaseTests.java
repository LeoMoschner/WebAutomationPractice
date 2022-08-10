package com.solvd.webAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import com.solvd.webAutomation.service.SessionPool;
import org.openqa.selenium.WebDriver;

public class BaseTests {
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();

    @BeforeMethod
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public void closeSession() {
        driver.close();
    }
}
