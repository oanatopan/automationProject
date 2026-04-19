package tests;

import helpMethods.ElementsMethod;
import helpMethods.FrameMethods;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.HomePage;
import sharedData.SharedData;

public class FramesTest extends SharedData {

    ElementsMethod elementsMethod;
    FrameMethods frameMethods;

    @Test
    public void metodaTest() {

        elementsMethod = new ElementsMethod(getDriver());
        frameMethods = new FrameMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        FramesPage frames = new FramesPage(getDriver());
        frames.clickFramesButton();
        frames.switchFrames("frame1", "frame2");
    }
}