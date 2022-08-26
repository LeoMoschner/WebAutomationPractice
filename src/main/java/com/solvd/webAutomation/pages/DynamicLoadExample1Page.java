package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadExample1Page extends BasicPage{
    private By startButton = By.tagName("button");
    private By finishText = By.id("finish");
    private By loadingBar = By.id("loading");
    public DynamicLoadExample1Page(WebDriver driver){
        super(driver);
    }
    public void clickStartButton(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(finishText)));
    }
    public String getFinishText(){
        return driver.findElement(finishText).getText();
    }
}
