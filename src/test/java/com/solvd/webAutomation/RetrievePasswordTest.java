package com.solvd.webAutomation;

import com.solvd.webAutomation.pages.ForgotPasswordPage;
import com.solvd.webAutomation.pages.HomePage;
import com.solvd.webAutomation.service.SessionPool;
import com.solvd.webAutomation.utils.HomePageLinks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetrievePasswordTest extends BaseTests{
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    private HomePage homePage = new HomePage(driver);
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
    private String EMAIL = "leomessi@goat.com";
    @Test
    public void retrievePasswordTest(){
        forgotPasswordPage = (ForgotPasswordPage) homePage
                .clickLinkByText(HomePageLinks.FORGOT_PASSWORD);
        forgotPasswordPage.setEmail(EMAIL);
        forgotPasswordPage.clickRetrievePw();
        Assert.assertFalse(forgotPasswordPage.getTittle().equals("Your e-mail's been sent!"));
    }
}
