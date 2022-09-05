package com.solvd.webAutomation;

import com.solvd.webAutomation.pages.DynamicContentPage;
import com.solvd.webAutomation.pages.HomePage;
import com.solvd.webAutomation.service.SessionPool;
import com.solvd.webAutomation.utils.HomePageLinks;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DynamicContentTest extends BaseTests{
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    private HomePage homePage = new HomePage(driver);
    private DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
    @Test
    public void dynamicContentTest(){
        dynamicContentPage = (DynamicContentPage) homePage.clickLinkByText(HomePageLinks.DYNAMIC_CONTENT);
        dynamicContentPage.getTextList();
    }
}
