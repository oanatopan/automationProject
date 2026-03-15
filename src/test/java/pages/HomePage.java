package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertFrameWindowMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formsMenu;

    public void clickAlertFrameWindow() {
        elementsMethod.javaScriptElement(alertFrameWindowMenu);
    }

    public void clickElementsMenu() {
        elementsMethod.javaScriptElement(elementsMenu);
    }

    public void clickFormsMenu() {
        elementsMethod.javaScriptElement(formsMenu);
    }
}
