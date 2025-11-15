package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class practiceForms {

    public WebDriver driver;

    @Test

    public void metodaTest() {

        //Deschidem un browser

        driver = new ChromeDriver();

        //Accesam un URL

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebElement formsMeniu = driver.findElement(By.xpath("//h5[text()='Forms']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", formsMeniu);

        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceForm.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstName = "Iulian";
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastName = "Roteliuc";
        lastNameElement.sendKeys(lastName);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmail = "roteliuc.iulian@gmail.com";
        userEmailElement.sendKeys(userEmail);

        WebElement mobileElement = driver.findElement(By.id("userNumber"));
        String mobile = "0746430354";
        mobileElement.sendKeys(mobile);

        //Date of birth interaction
        WebElement dateOfBirth=driver.findElement(By.id("dateOfBirthInput"))   ;
        dateOfBirth.click();
        WebElement monthElements= driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect= new Select(monthElements);
        String monthValue="January";
         monthSelect.selectByVisibleText(monthValue);

        WebElement yearElements = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select(yearElements);
        String yearValue="January";
        yearSelect.selectByVisibleText(yearValue);

        String dayValue="15";
        List<WebElement> daysList= driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day--0')and not(contains(@class,'outside-month'))]"));
        for(int index=0;index<daysList.size();index++) {
            if (daysList.get(index).getText().equals(dayValue)) {
                daysList.get(index).click();
                break;


             }
        }
    }

}
