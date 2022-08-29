package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadExample2Page extends BasicPage{
    private By startButton = By.tagName("Button");
    private By finishText = By.id("finish");
    private By loadingBar = By.id("loading");
    public DynamicLoadExample2Page(WebDriver driver){
        super (driver);
    }
    public void clickStartButton(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));
    }
    public String getFinishText(){
        return driver.findElement(finishText).getText();
    }
}
