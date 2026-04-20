package tests;

import modelObject.AlertModel;
import org.testng.annotations.Test;
import pages.AlertWindows;
import pages.HomePage;
import sharedData.Hooks;

public class AlertTest extends Hooks {

    @Test
    public void metodaTest() {

        AlertModel testData = new AlertModel("src/test/resources/inputData/AlertData.json");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertWindows alertWindows = new AlertWindows(getDriver());
        alertWindows.clickAlertSubMenu();
        alertWindows.dealAlertProcess(testData);
    }
}