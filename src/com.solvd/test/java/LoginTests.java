import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecuredAreaPage;
import service.SessionPool;

/**
 * Login Tests:
 * 1. Login with correct username and password
 * 2. Login with correct username but incorrect password
 * 3. Login with incorrect username
 * 4. Login without username and password
 * */
public class LoginTests extends BaseTests{
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    private HomePage homePage = new HomePage(driver);
    private LoginPage loginPage;
    private SecuredAreaPage securedAreaPage;
    private final static String CORRECT_USERNAME = "tomsssmith";
    private final static String CORRECT_PASSWORD = "SuperSecretPassword!";
    @Test
    public void correctUserAndPasswordTest() {
        loginPage = (LoginPage) homePage.clickLinkByText("Form Authentication");
        loginPage.setUserName(CORRECT_USERNAME);
        loginPage.setPassword(CORRECT_PASSWORD);
        securedAreaPage = loginPage.clickLoginButton();
        Assert.assertTrue(securedAreaPage.getTextAlert().contains("You logged into a secure area!"));
    }
}
