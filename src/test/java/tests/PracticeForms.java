package tests;

import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class PracticeForms {

    public WebDriver driver;
    public ElementsMethod elementsMethod;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        elementsMethod = new ElementsMethod(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickFormsMenu();

        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethod.javaScriptElement(practiceForm);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        elementsMethod.fillElement(firstNameElement, "Oana");

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        elementsMethod.fillElement(lastNameElement, "Topan");

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        elementsMethod.fillElement(userEmailElement, "oanadanatopan@gmail.com");

        WebElement mobileElement = driver.findElement(By.id("userNumber"));
        elementsMethod.fillElement(mobileElement, "0745213252");

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        elementsMethod.clickElement(dateOfBirth);

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        elementsMethod.dropDownElement(monthElement, "January");

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        elementsMethod.dropDownElement(yearElement, "1992");

        String dayValue = "15";
        List<WebElement> daysList = driver.findElements(
                By.xpath("//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))]")
        );

        for (int index = 0; index < daysList.size(); index++) {
            if (daysList.get(index).getText().equals(dayValue)) {
                elementsMethod.clickElement(daysList.get(index));
                break;
            }
        }

        WebElement photoElementField = driver.findElement(By.id("uploadPicture"));
        File resourcesDirectory = new File("src/test/resources/Catalin.jpg");
        photoElementField.sendKeys(resourcesDirectory.getAbsolutePath());

        driver.quit();
    }
}