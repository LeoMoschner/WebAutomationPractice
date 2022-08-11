package com.solvd.webAutomation.pages;

import com.solvd.webAutomation.utils.HomePageLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShiftingContentPage extends BasicPage{
    private By menuElementLink = By.linkText("Example 1: Menu Element");
    public ShiftingContentPage(WebDriver driver) {
        super(driver);
    }

    public MenuElementPage clickMenuElement() {
        driver.findElement(menuElementLink).click();
        return new MenuElementPage(driver);
    }
}
