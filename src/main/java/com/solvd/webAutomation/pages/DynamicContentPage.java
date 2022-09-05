package com.solvd.webAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class DynamicContentPage extends BasicPage{
    /**
     * testear que el texto o la img cambien cuando la pagina se refresca
     * pero que el dom en si siga igual.ç
     * usar navigation options (para tirar refresh)
     * */
    private final By textBoxes= By.xpath("//*[@class='large-10 columns']");
    public DynamicContentPage (WebDriver driver){
        super(driver);
    }
    public void getTextList(){
        List<WebElement> webElements = driver.findElements(textBoxes);
        webElements.stream().forEach(txt -> {
            System.out.println(txt.getText());
            System.out.println();
        });
    }
}
