package tests;

import helpMethods.ElementsMethod;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.Hooks;

public class TabWindowTest extends Hooks {

    ElementsMethod elementsMethod;
    TabMethods tabMethods;

    @Test
    public void metodaTest() {

        int newTabIndex = 1;
        int mainTabIndex = 0;

        elementsMethod = new ElementsMethod(getDriver());
        tabMethods = new TabMethods(getDriver());

        WebElement alertMenu = getDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(alertMenu);

        WebElement tabButton = getDriver().findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethod.javaScriptElement(tabButton);

        WebElement newTabButton = getDriver().findElement(By.id("tabButton"));
        elementsMethod.clickElement(newTabButton);

        tabMethods.switchSpecificTab(newTabIndex);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(mainTabIndex);

        WebElement newWindowElement = getDriver().findElement(By.id("windowButton"));
        elementsMethod.javaScriptElement(newWindowElement);
        tabMethods.switchSpecificTab(newTabIndex);
    }
}