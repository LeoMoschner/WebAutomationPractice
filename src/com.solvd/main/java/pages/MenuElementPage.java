package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuElementPage extends BasicPage{

    private By elementList = By.tagName("li");
    public MenuElementPage(WebDriver driver){
        super(driver);
    }

    public int countElements() {
        List<WebElement> elements = driver.findElements(elementList);
        return elements.size();
    }
}
