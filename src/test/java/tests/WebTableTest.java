package tests;

import modelObject.WebTableModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.Hooks;

public class WebTableTest extends Hooks {

    @Test
    public void metodaTest() {

        WebTableModel testData = new WebTableModel("src/test/resources/inputData/WebTablesData.json");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        System.out.println("STEP: URL curent este: " + getDriver().getCurrentUrl());
        Assert.assertTrue(getDriver().getCurrentUrl().contains("webtables"), "Pagina Web Tables nu s-a deschis.");

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.createProcess(testData);
        webTablePage.editProcess(testData);
        webTablePage.deleteProcess(testData);
    }
}