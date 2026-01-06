package tests;
import helpMethods.ElementsMethod;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesTest {
    public WebDriver driver;
    ElementsMethod elementsMethod;
    FrameMethods frameMethods;


    @Test

    public void metodaTest() {

        //Deschidem un browser

        driver = new ChromeDriver();

        //Accesam un URL

        driver.get("https://demoqa.com/");
        elementsMethod = new ElementsMethod(driver);
        frameMethods = new FrameMethods(driver);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement framesMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(framesMeniu);
        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementsMethod.clickElement(tabButton);

        frameMethods.switchToSpecificFrame("frame1");
        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement.getText());
        frameMethods.switchToParentFrame();

        frameMethods.switchToSpecificFrame("frame2");
        WebElement sampleTextElement1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement1.getText());

        driver.quit();


    }


}