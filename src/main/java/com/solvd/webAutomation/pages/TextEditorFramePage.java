package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextEditorFramePage extends BasicPage{
    private final By textBox = By.id("tinymce");
    //Negrita
    private final By boldButton = By.xpath("//button[@title = 'Bold']");
    public TextEditorFramePage(WebDriver driver){
        super(driver);
    }
    private void switchToTextFrame (){
        String textEditorId = "mce_0_ifr";
        driver.switchTo().frame(textEditorId);
    }
    private void switchToMainFrame(){
        driver.switchTo().parentFrame();
    }
    public void setTextBox (String inputText){
        switchToTextFrame();
        driver.findElement(textBox).sendKeys(inputText);
    }
    public String getText (){
        return driver.findElement(textBox).getText();
    }
    public void clearTextBox(){
        switchToTextFrame();
        driver.findElement(textBox).clear();
    }
    public void clickBoldButton(){
        switchToMainFrame();
        driver.findElement(boldButton).click();
    }
}
