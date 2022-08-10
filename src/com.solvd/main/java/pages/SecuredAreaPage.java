package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecuredAreaPage extends BasicPage {

    private By statusAlert = By.id("flash");
    public SecuredAreaPage (WebDriver driver){
        super(driver);
    }
    public String getTextAlert(){
        return driver.findElement(statusAlert).getText();
    }
}
