package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertFrameWindowMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAlertFrameWindow(){
        elementsMethods.javaScriptElement(alertFrameWindowMenu);
        loggerUtility.infoLog(" The user clicks on Alert, Frame & Windows");
    }

    public void clickElementsMenu(){
        elementsMethods.javaScriptElement(elementsMenu);
        loggerUtility.infoLog(" The user clicks on Elements menu");
    }

}