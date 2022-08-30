package com.solvd.webAutomation;

import com.solvd.webAutomation.utils.HomePageLinks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.solvd.webAutomation.pages.HomePage;
import com.solvd.webAutomation.pages.LoginPage;
import com.solvd.webAutomation.pages.SecuredAreaPage;
import com.solvd.webAutomation.service.SessionPool;

/**
 * Login Tests:
 * 1. Login with correct username and password
 * 2. Login with correct username but incorrect password
 * 3. Login with incorrect username
 * 4. Login without username and password
 *
 * Notas falopa:
 *      Sacar las credenciales a algun enum o xml
 *      Sacar "link Text" a algun otro lado, no puedo estar
 *      repitiendo "Form Authentication" 200 veces.
 *
 *      Ver los asserts en los que no se va a la otra pagina;
 *      Esta bien hacerlos comparando con la pagina secured?
 *
 *
 * */
public class LoginTests extends BaseTests {
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    private HomePage homePage = new HomePage(driver);
    private LoginPage loginPage;
    private SecuredAreaPage securedAreaPage;
    private final static String CORRECT_USERNAME = "tomsmith";
    private final static String CORRECT_PASSWORD = "SuperSecretPassword!";
    private final static String WRONG_PASSWORD = "SuperWrongPassword!";
    private final static String WRONG_USERNAME = "NotTomSmith";
    @Test
    public void correctCredentialsTest() {
        loginPage = (LoginPage) homePage.clickLinkByText(HomePageLinks.LOGIN);
        loginPage.setUserName(CORRECT_USERNAME);
        loginPage.setPassword(CORRECT_PASSWORD);
        securedAreaPage = loginPage.clickLoginButton();
        Assert.assertTrue(securedAreaPage.getTextAlert().contains("You logged into a secure area!"));
    }
    @Test
    public void noCredentialsTest() {
        loginPage = (LoginPage) homePage.clickLinkByText(HomePageLinks.LOGIN);
        securedAreaPage = loginPage.clickLoginButton();
        Assert.assertFalse(securedAreaPage.getTextAlert().contains("You logged into a secure area!"));
    }
    @Test
    public void correctUsernameWrongPw () {
        loginPage = (LoginPage) homePage.clickLinkByText(HomePageLinks.LOGIN);
        loginPage.setUserName(CORRECT_USERNAME);
        loginPage.setPassword(WRONG_PASSWORD);
        securedAreaPage = loginPage.clickLoginButton();
        Assert.assertFalse(securedAreaPage.getTextAlert().contains("You logged into a secure area!"));
    }
    @Test
    public void wrongUserName() {
        loginPage = (LoginPage) homePage.clickLinkByText(HomePageLinks.LOGIN);
        loginPage.setUserName(WRONG_USERNAME);
        loginPage.setPassword(CORRECT_PASSWORD);
        securedAreaPage = loginPage.clickLoginButton();
        Assert.assertFalse(securedAreaPage.getTextAlert().contains("You logged into a secure area!"));
     }
}
