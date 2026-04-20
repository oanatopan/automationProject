package tests;

import helpMethods.ElementsMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablesPage;
import sharedData.Hooks;
import sharedData.SharedData;

public class WebTableTest extends Hooks {

    ElementsMethod elementsMethod;

    @Test
    public void metodaTest() {

        elementsMethod = new ElementsMethod(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        System.out.println("STEP: URL curent este: " + getDriver().getCurrentUrl());
        Assert.assertTrue(getDriver().getCurrentUrl().contains("webtables"), "Pagina Web Tables nu s-a deschis.");

        WebTablesPage webTablePage = new WebTablesPage(getDriver());
        webTablePage.createProcess();
        webTablePage.editProcess();
        webTablePage.deleteProcess();
    }
}