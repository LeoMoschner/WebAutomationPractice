package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DynamicLoadPage extends BasicPage {
    private By example1 = By.linkText("Example 1: Element on page that is hidden");
    private By example2 = By.linkText("Example 2: Element rendered after the fact");
    public DynamicLoadPage(WebDriver driver){
        super(driver);
    }
    public DynamicLoadExample1Page clickExample1Link(){
        driver.findElement(example1).click();
        return new DynamicLoadExample1Page(driver);
    }
    public DynamicLoadExample2Page clickExample2Link(){
        driver.findElement(example2).click();
        return new DynamicLoadExample2Page(driver);
    }
}
