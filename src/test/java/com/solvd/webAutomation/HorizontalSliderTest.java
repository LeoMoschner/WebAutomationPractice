package com.solvd.webAutomation;

import com.solvd.webAutomation.pages.HomePage;
import com.solvd.webAutomation.pages.HorizontalSliderPage;
import com.solvd.webAutomation.service.SessionPool;
import com.solvd.webAutomation.utils.HomePageLinks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BaseTests{
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    private HomePage homePage = new HomePage(driver);
    private HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage(driver);
    @Test
    public void horizontalSliderTest() {
        horizontalSliderPage = (HorizontalSliderPage) homePage
                .clickLinkByText(HomePageLinks.HORIZONTAL_SLIDER);
        horizontalSliderPage.moveSlider(8);
        Assert.assertEquals(horizontalSliderPage.getSliderValue(), "4");
    }
}
