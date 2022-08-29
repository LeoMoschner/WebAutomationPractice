package com.solvd.webAutomation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextMenuPage extends BasicPage{
    private By box = By.id("hot-spot");
    Actions actions = new Actions(driver);
    public ContextMenuPage(WebDriver driver){
        super(driver);
    }
    public void rightClickBox(){
        actions.contextClick(driver.findElement(box)).perform();
        actions.click().perform();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

}
