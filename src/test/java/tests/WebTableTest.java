package tests;

import helpMethods.ElementsMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablesPage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    ElementsMethod elementsMethod;

    @Test
    public void metodaTest() {

        elementsMethod = new ElementsMethod(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickWebTable();

        System.out.println("STEP: URL curent este: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("webtables"), "Pagina Web Tables nu s-a deschis.");

        WebTablesPage webTablePage = new WebTablesPage(driver);
        webTablePage.createProcess();
        webTablePage.editProcess();
        webTablePage.deleteProcess();
    }
}