package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SharedData {

   private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public void prepareEnvironment() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void clearEnvironment() {
        driver.quit();
    }
}