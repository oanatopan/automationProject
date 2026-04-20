package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementsMethod;
import org.testng.annotations.Test;
import pages.AlertWindows;
import pages.HomePage;
import sharedData.Hooks;


public class AlertTest extends Hooks {

    ElementsMethod elementsMethod;
    AlertMethods alertMethods;

    @Test

    public void metodaTest() {

        elementsMethod = new ElementsMethod(getDriver());
        alertMethods = new AlertMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertWindows alertWindows = new AlertWindows(getDriver());
        alertWindows.clickAlertSubMenu();
        alertWindows.dealAlertProcess();

    }
}