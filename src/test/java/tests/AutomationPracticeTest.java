package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class AutomationPracticeTest {
    public WebDriver driver;
@BeforeMethod
    public void setUp()  {

    driver = new ChromeDriver();

    driver.get("http://automationpractice.pl/index.php");
    driver.manage().window().maximize();
}

@Test

public void metodaTest() {


        WebElement addElement = driver.findElement(By.className("login"));
         addElement.click();

        WebElement emailElement = driver.findElement(By.id("email_create"));
        String userEmail = "oana@gmail.com";
        emailElement.sendKeys(userEmail);

        WebElement submitElement = driver.findElement(By.id("SubmitCreate"));
        submitElement.click();

        // }

        WebDriverWait shortwait = new WebDriverWait(driver, Duration. ofSeconds(5));
        WebElement genderElement = shortwait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
        genderElement.click();

        WebElement radioButton = driver.findElement(By.id("id_gender2"));
        radioButton.click();

        //WebElement customerFirstNameElement = driver.findElement(By.id("customer_fistname"));
        //String customerFirstName = "Oana";
        //customerFirstName.sendKeys(customerFirstName);

    }
}