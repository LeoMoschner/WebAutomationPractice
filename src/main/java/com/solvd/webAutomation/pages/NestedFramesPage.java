package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BasicPage{
    private final By topFrame = By.name("frame-top");
    private final By bottomFrame = By.name("frame-bottom");
    private final By topLeftFrame = By.name("frame-left");
    private final By topMiddleFrame = By.name("frame-middle");
    private final By topRightFrame = By.name("frame-right");
    private final By framesBody = By.tagName("body");
    public NestedFramesPage (WebDriver driver){
        super(driver);
    }
    public void switchToMainFrame(){
        driver.switchTo().parentFrame();
    }
    public void switchToTopFrame(){
        driver.switchTo().frame(driver.findElement(topFrame));
    }
    private void switchToBottomFrame(){
        driver.switchTo().frame(driver.findElement(bottomFrame));
    }
    private void switchToTopLeftFrame(){
        driver.switchTo().frame(driver.findElement(topLeftFrame));
    }
    private void switchToTopMiddleFrame(){
        driver.switchTo().frame(driver.findElement(topMiddleFrame));
    }
    private void switchToTopRightFrame(){
        driver.switchTo().frame(driver.findElement(topRightFrame));
    }
    public String getBottomFrameText(){
        switchToBottomFrame();
        return driver.findElement(framesBody).getText();
    }
    public String getTopLeftFrameText(){
        switchToTopLeftFrame();
        return driver.findElement(framesBody).getText();
    }
    public String getTopMiddleFrameText(){
        switchToMainFrame();
        switchToTopMiddleFrame();
        return driver.findElement(framesBody).getText();
    }
    public String getTopRightFrameText(){
        switchToMainFrame();
        switchToTopRightFrame();
        return driver.findElement(framesBody).getText();
    }

}
