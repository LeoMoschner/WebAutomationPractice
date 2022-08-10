package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasicPage{
    private By userName = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.tagName("button");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUserName(String text){
        driver.findElement(userName)
                .sendKeys(text);
    }

    public void setPassword(String text) {
        driver.findElement(password)
                .sendKeys(text);
    }

    public SecuredAreaPage clickLoginButton(){
        driver.findElement(loginButton)
                .click();
        return new SecuredAreaPage(driver);
    }
}
