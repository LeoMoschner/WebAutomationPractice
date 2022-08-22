package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage extends BasicPage{
    private By slider = By.tagName("input");
    private By sliderValue = By.id("range");
    Actions asd = new Actions(driver);

    public HorizontalSliderPage(WebDriver driver){
        super(driver);
    }
    public String getSliderValue(){
        return (driver.findElement(sliderValue).getText());
    }
    public void moveSlider(int times) {
        WebElement sliderAux = driver.findElement(slider);
        for (int i = 0; i < times; i++){
            sliderAux.sendKeys(Keys.ARROW_RIGHT);
        }
    }
}
