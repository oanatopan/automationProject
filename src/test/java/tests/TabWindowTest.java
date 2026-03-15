package tests;

import helpMethods.ElementsMethod;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import java.time.Duration;

public class TabWindowTest {

    public WebDriver driver;
    ElementsMethod elementsMethod;
    TabMethods tabMethods;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        elementsMethod = new ElementsMethod(driver);
        tabMethods = new TabMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        WebElement browserWindowsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethod.javaScriptElement(browserWindowsSubMenu);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementsMethod.clickElement(newTabButton);

        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);

        driver.quit();
    }
}