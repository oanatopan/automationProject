package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.FramesPage;
import java.time.Duration;

public class FramesTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        FramesPage framesPage = new FramesPage(driver);
        framesPage.clickFramesButton();
        framesPage.switchFrames("frame1", "frame2");

        driver.quit();
    }
}