package tests;

import helpMethods.ElementsMethod;
import helpMethods.FrameMethods;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.HomePage;
import sharedData.Hooks;
import sharedData.SharedData;

public class FramesTest extends Hooks {


    @Test
    public void metodaTest() {


        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        FramesPage frames = new FramesPage(getDriver());
        frames.clickFramesButton();
        frames.switchFrames("frame1", "frame2");
    }
}