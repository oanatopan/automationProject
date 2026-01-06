package tests;

import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class WebTableTest {

    public WebDriver driver;
    public ElementsMethod elementsMethod;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        elementsMethod = new ElementsMethod(driver);

        WebElement elementsMeniu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMethod.javaScriptElement(elementsMeniu);

        WebElement webTable = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementsMethod.clickElement(webTable);

        elementsMethod.clickElement(driver.findElement(By.id("addNewRecordButton")));
        elementsMethod.fillElement(driver.findElement(By.id("firstName")), "Oana");
        elementsMethod.fillElement(driver.findElement(By.id("lastName")), "Topan");
        elementsMethod.fillElement(driver.findElement(By.id("userEmail")), "oanadanatopan@gmail.com");
        elementsMethod.fillElement(driver.findElement(By.id("age")), "33");
        elementsMethod.fillElement(driver.findElement(By.id("salary")), "5000");
        elementsMethod.fillElement(driver.findElement(By.id("department")), "Discogs");
        elementsMethod.clickElement(driver.findElement(By.id("submit")));

        List<WebElement> continutTabelNou = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelNou.size(), 4, "Marimea tabelului nu este 4");

        elementsMethod.clickElement(driver.findElement(By.id("edit-record-4")));
        elementsMethod.fillElement(driver.findElement(By.id("firstName")), "Oana Edit");
        elementsMethod.fillElement(driver.findElement(By.id("lastName")), "Top");
        elementsMethod.clickElement(driver.findElement(By.id("submit")));

        elementsMethod.clickElement(driver.findElement(By.id("delete-record-4")));

        List<WebElement> continutTabelSters = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelSters.size(), 3, "Noul tabel nu contine 3 randuri");

        driver.quit();
    }
}