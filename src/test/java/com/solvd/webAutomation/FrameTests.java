package com.solvd.webAutomation;

import com.solvd.webAutomation.pages.FramesPage;
import com.solvd.webAutomation.pages.HomePage;
import com.solvd.webAutomation.pages.NestedFramesPage;
import com.solvd.webAutomation.pages.TextEditorFramePage;
import com.solvd.webAutomation.service.SessionPool;
import com.solvd.webAutomation.utils.HomePageLinks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends BaseTests{
    private WebDriver driver = SessionPool.getINSTANCE().getDriver();
    private HomePage homePage = new HomePage(driver);
    private FramesPage framesPage = new FramesPage(driver);
    private final String INPUT_TEXT = "80 dias para Qatar";
    private TextEditorFramePage textEditorFramePage = new TextEditorFramePage(driver);
    private NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);

    @Test
    public void typeBoldText(){
        framesPage = (FramesPage) homePage.clickLinkByText(HomePageLinks.FRAMES);
        textEditorFramePage = framesPage.clickiFrameLink();
        textEditorFramePage.clearTextBox();
        textEditorFramePage.clickBoldButton();
        textEditorFramePage.setTextBox(INPUT_TEXT);
        Assert.assertEquals(textEditorFramePage.getText(), INPUT_TEXT);
    }
    @Test
    public void nestedFramesTextTest(){
        framesPage = (FramesPage) homePage.clickLinkByText(HomePageLinks.FRAMES);
        nestedFramesPage = framesPage.clickNestedFrameLink();
        Assert.assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM");
        nestedFramesPage.switchToMainFrame();
        nestedFramesPage.switchToTopFrame();
        Assert.assertEquals(nestedFramesPage.getTopLeftFrameText(), "LEFT");
        Assert.assertEquals(nestedFramesPage.getTopMiddleFrameText(), "MIDDLE");
        Assert.assertEquals(nestedFramesPage.getTopRightFrameText(), "RIGHT");
    }
}
