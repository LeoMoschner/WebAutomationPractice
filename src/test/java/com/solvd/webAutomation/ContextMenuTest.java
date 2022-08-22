package com.solvd.webAutomation;

import com.solvd.webAutomation.pages.ContextMenuPage;
import com.solvd.webAutomation.pages.HomePage;
import com.solvd.webAutomation.service.SessionPool;
import com.solvd.webAutomation.utils.HomePageLinks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTests{
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    private HomePage homePage = new HomePage(driver);
    private ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
    @Test
    public void idkTest(){
        contextMenuPage = (ContextMenuPage) homePage.clickLinkByText(HomePageLinks.CONTEXT_MENU);
        contextMenuPage.rightClickBox();
        String alertText = contextMenuPage.getAlertText();
        contextMenuPage.acceptAlert();
        Assert.assertEquals(alertText, "You selected a context menu");
    }
}
