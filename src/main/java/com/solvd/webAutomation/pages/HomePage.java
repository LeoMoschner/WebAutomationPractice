package com.solvd.webAutomation.pages;

import com.solvd.webAutomation.utils.HomePageLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasicPage{
    public HomePage (WebDriver driver){
        super(driver);
    }
    private BasicPage pageFactory (HomePageLinks link){
        switch (link){
            case LOGIN: return new LoginPage(driver);
            case SHIFT_CONTENT: return new ShiftingContentPage(driver);
            case FORGOT_PASSWORD: return new ForgotPasswordPage(driver);
            case HORIZONTAL_SLIDER: return new HorizontalSliderPage(driver);
            case CONTEXT_MENU: return new ContextMenuPage(driver);
            default:
                System.out.println("ERROR: There is no page called " + link.getLinkText());
                return null;
        }
    }
    public BasicPage clickLinkByText(HomePageLinks link){
        driver.findElement(By.linkText(link.getLinkText())).click();
        return pageFactory(link);
    }

}
