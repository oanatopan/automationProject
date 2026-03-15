package tests;

import helpMethods.ElementsMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class PracticeForms {

    public WebDriver driver;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        elementsMethod = new ElementsMethod(driver);


        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethod.javaScriptElement(practiceForm);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));

        WebElement lastNameElement = driver.findElement(By.id("lastName"));

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));

        WebElement mobileElement = driver.findElement(By.id("userNumber"));

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        elementsMethod.clickElement(dateOfBirth);

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));

        String dayValue = "15";
        for (int index = 0; index < daysList.size(); index++) {
            if (daysList.get(index).getText().equals(dayValue)) {
                elementsMethod.clickElement(daysList.get(index));
                break;
            }
        }

        WebElement photoElementField = driver.findElement(By.id("uploadPicture"));
        File resourcesDirectory = new File("src/test/resources/Catalin.jpg");
        photoElementField.sendKeys(resourcesDirectory.getAbsolutePath());

    }
}