package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasicPage{
    private By nestedFramesLink = By.linkText("Nested Frames");
    private By iFramesLink = By.linkText("iFrame");
    public FramesPage (WebDriver driver) {
        super(driver);
    }
    public NestedFramesPage clickNestedFrameLink(){
        driver.findElement(nestedFramesLink).click();
        return new NestedFramesPage(driver);
    }
    public TextEditorFramePage clickiFrameLink(){
        driver.findElement(iFramesLink).click();
        return new TextEditorFramePage(driver);
    }
}
