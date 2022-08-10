package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasicPage{

    private By shiftingContentLink = By.linkText("Shifting Content");

    public HomePage (WebDriver driver){
        super(driver);
    }

    private BasicPage pageFactory (String pageName){
        switch (pageName){
            case "Shifting Content": return new ShiftingContentPage(driver);
            case "Form Authentication": return new LoginPage(driver);
            default:
                System.out.println("ERROR: There is no page called " + pageName);return null;
        }

    }
    public BasicPage clickLinkByText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
        return pageFactory(linkText);
    }

}
