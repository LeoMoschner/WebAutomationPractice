package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasicPage{
    private By emailBox = By.id("email");
    private By retrievePwButton = By.id("form_submit");
    private By pageTittle = By.tagName("h1");
    public ForgotPasswordPage (WebDriver driver){
        super(driver);
    }
    public void setEmail(String email){
        driver.findElement(emailBox).sendKeys(email);
    }
    public void clickRetrievePw (){
        driver.findElement(retrievePwButton).click();
    }
    public String getTittle() {
        return driver.findElement(pageTittle).getText();
    }
}
