package pages;

import helpMethods.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    public WebDriver driver;
    public ElementsMethod elementsMethod;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(this.driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTableSubMenu;

    public void clickWebTable() {
        elementsMethod.clickElement(webTableSubMenu);
    }
}