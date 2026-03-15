package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;


    @Test

    public void metodaTest() {

        //Deschidem un browser

        driver = new ChromeDriver();

        //Accesam un URL

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        // wait implicit ( vegheaza asupra codului);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertMeniu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Alerts']"));
        tabButton.click();

        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        firstAlertElement.click();
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

        WebElement secondAlert= driver.findElement(By.id("timerAlertButton"));
        secondAlert.click();

        //wait explicit
        WebDriverWait waitExplicit=new WebDriverWait(driver,Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
        Alert secondAlertElement =driver.switchTo().alert();
        System.out.println(secondAlertElement.getText());
        secondAlertElement.accept();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        js.executeScript("arguments[0].click();", thirdAlertElement);
        Alert thirdAlert = driver.switchTo().alert();
        thirdAlert.dismiss();

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        js.executeScript("arguments[0].click();", fourthAlertElement);
        Alert fourthAlert = driver.switchTo().alert();
        fourthAlert.sendKeys("text123");
        fourthAlert.accept();

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String expectedText = "You selected Cancel";
        Assert.assertEquals(textThirdAlert.getText(), expectedText);

    }

}
