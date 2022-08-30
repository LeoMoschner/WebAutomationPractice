package com.solvd.webAutomation;


import com.solvd.webAutomation.pages.DynamicLoadExample1Page;
import com.solvd.webAutomation.pages.DynamicLoadExample2Page;
import com.solvd.webAutomation.pages.DynamicLoadPage;
import com.solvd.webAutomation.pages.HomePage;
import com.solvd.webAutomation.service.SessionPool;
import com.solvd.webAutomation.utils.HomePageLinks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadTest extends BaseTests {
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    private HomePage homePage = new HomePage(driver);
    private DynamicLoadPage dynamicLoadPage = new DynamicLoadPage(driver);
    private DynamicLoadExample1Page dynamicLoadExample1Page = new DynamicLoadExample1Page(driver);
    private DynamicLoadExample2Page dynamicLoadExample2Page = new DynamicLoadExample2Page(driver);
    @Test
    public void example1Test (){
        dynamicLoadPage = (DynamicLoadPage) homePage.clickLinkByText(HomePageLinks.DYNAMIC_LOAD);
        dynamicLoadExample1Page = dynamicLoadPage.clickExample1Link();
        dynamicLoadExample1Page.clickStartButton();
        Assert.assertEquals(dynamicLoadExample1Page.getFinishText(), "Hello World!");
    }
    @Test
    public void example2Test(){
        dynamicLoadPage = (DynamicLoadPage) homePage.clickLinkByText(HomePageLinks.DYNAMIC_LOAD);
        dynamicLoadExample2Page = dynamicLoadPage.clickExample2Link();
        dynamicLoadExample2Page.clickStartButton();
        Assert.assertEquals(dynamicLoadExample2Page.getFinishText(), "Hello World!");
    }
}
