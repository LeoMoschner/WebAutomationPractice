import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuElementPage;
import pages.ShiftingContentPage;
import service.SessionPool;

/**First exercise.
 *      1. Go to Home page
 *      2. Click on shifting content link
 *      3. click on menu element link
 *      4. count how many elements are there (there should be 5)
 * */
public class Test1 extends BaseTests {
    WebDriver driver = SessionPool.getINSTANCE().getDriver();
    private HomePage homePage = new HomePage (driver);
    private ShiftingContentPage shiftingContentPage = new ShiftingContentPage(driver);
    private MenuElementPage menuElementPage = new MenuElementPage(driver);
    private final static int CURRENT_ELEMENT_AMOUNT = 5;

    @Test
    public void testMenuElementsAmount() {
        shiftingContentPage = (ShiftingContentPage) homePage.clickLinkByText("Shifting Content");
        menuElementPage = shiftingContentPage.clickMenuElement();
        int elementsAmount = menuElementPage.countElements();
        System.out.println("Amount of Elements: " + elementsAmount);
        Assert.assertEquals(elementsAmount, CURRENT_ELEMENT_AMOUNT);
    }
}
