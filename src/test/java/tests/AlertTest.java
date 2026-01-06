package tests;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    ElementsMethod elementsMethod;
    AlertsMethods alertMethods;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        elementsMethod = new ElementsMethod(driver);
        alertMethods = new AlertsMethods(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(alertMeniu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementsMethod.clickElement(tabButton);

        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethod.clickElement(firstAlertElement);
        alertMethods.acceptAlert();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementsMethod.clickElement(secondAlert);
        alertMethods.acceptAlert();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethod.clickElement(thirdAlertElement);
        boolean chooseAccept = true;
        alertMethods.acceptAlert(chooseAccept);

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethod.javaScriptElement(fourthAlertElement);
        alertMethods.fillAlert("Oana Topan");

        driver.quit();
    }
}